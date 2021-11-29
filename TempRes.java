import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Cael O'Flaherty
 * This Class creates an object for the reservations to temporarily be stored in.
 */
public class TempRes {
    int reservationNum;
    String reservationName;
    String reservationType;
    String checkIn;
    String checkOut;
    String numberOfRooms;
    String roomType;

    /**
     * Constructor for TempRes object.
     * @param reservationNum
     * @param reservationName
     * @param reservationType
     * @param checkIn
     * @param checkOut
     * @param numberOfRooms
     * @param roomType
     */
    public TempRes(int reservationNum, String reservationName, String reservationType, String checkIn, String checkOut, String numberOfRooms, String roomType) {
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

    public static Map<String, List<TempRes>> loadCSV(String path) {
        Map<String, List<TempRes>> result = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            result = new HashMap<>();
            while((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int resNum = Integer.parseInt(fields[0]);

                StringTokenizer st = new StringTokenizer(fields[6], "/");
                while(st.hasMoreTokens()) {
                    String reservationType = st.nextToken();
                    List<TempRes> reservations = result.computeIfAbsent(reservationType, k -> new ArrayList<>());
                    reservations.add(new TempRes(resNum, fields[1], fields[2], fields[3], fields[4], fields[5], reservationType));
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