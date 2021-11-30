import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Cael O'Flaherty
 * @author Dennis Kolomiyets
 * This Class creates an object for the reservations to temporarily be stored in.
 */
public class TempRes {
    int reservationNum;
    String reservationName;
    String reservationType;
    String checkIn;
    String checkOut;
    int numberOfRooms;
    String roomType;

    /**
     * Constructor for TempRes object.
     * @param reservationNum int, reservation number.
     * @param reservationName String, name of reservation.
     * @param reservationType String, type of reservation e.g. AP or S.
     * @param checkIn String, date of check in.
     * @param checkOut String, date of check out.
     * @param numberOfRooms int, number of rooms reserved.
     * @param roomType String, type of room booked e.g. deluxe standard.
     */
    public TempRes(int reservationNum, String reservationName, String reservationType, String checkIn, String checkOut, int numberOfRooms, String roomType) {
        this.reservationNum = reservationNum;
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;
    }

    /**
     * Getter for Reservation number.
     * @return Reservation Number.
     */
    public int getReservationNum() {
        return reservationNum;
    }

    /**
     * ToString method for the TempRes object.
     * @return A string displaying all data in a TempRes object.
     */
    public String toString() {
        return (reservationNum + "," + reservationName + "," + reservationType + "," + checkIn + "," + checkOut + "," +
                numberOfRooms + "," + roomType + "\n");
    }

    
    /**
    *This method is used by the checkVaccancy method in Date Checker to create a HashMap to store information regarding reservations in memory for easier access later.
    * @param path String, file path to be loaded in
    * @return reservation loaded into memory
    */
    public static Map<String, List<TempRes>> loadCSV(String path) {
        Map<String, List<TempRes>> result = null;
        BufferedReader br = null;
        try {
            // creates new buffered reader
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            result = new HashMap<>();
            //reads lines and stores reservation number and number of rooms
            while((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int resNum = Integer.parseInt(fields[0]);
                int numOfRooms = Integer.parseInt(fields[5]);
                
                //tokenizes the room types field with the delimeter of "/"
                StringTokenizer st = new StringTokenizer(fields[6], "/");
                while(st.hasMoreTokens()) {
                    String reservationType = st.nextToken();
                    List<TempRes> reservations = result.computeIfAbsent(reservationType, k -> new ArrayList<>());
                    reservations.add(new TempRes(resNum, fields[1], fields[2], fields[3], fields[4], numOfRooms, reservationType));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
