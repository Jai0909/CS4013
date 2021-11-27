import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Cael O'Flaherty
 * This class writes data to payment.csv and reservations.csv. It also removes a reservation from a csv file.
 */
public class FileWriter {
    //Reservation csv writer data fields.
    private File reservationWriterFile = new File("src/reservations.csv");
    private int reservationNum;
    private String reservationName;
    private String reservationType;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private String roomType;

    //Payment csv writer data fields.
    private File paymentWriter = new File("src/payment.csv");
    private String isItPaid;
    private double totalCost;

    /**
     * This constructor makes a FileWriter object that writes data to reservations.csv.
     *
     * @param reservationNum
     * @param reservationName
     * @param reservationType
     * @param checkIn
     * @param checkOut
     * @param numberOfRooms
     * @param roomType
     * @throws IOException
     */
    public FileWriter(int reservationNum, String reservationName, String reservationType, String checkIn, String checkOut, int numberOfRooms,
                      String roomType) throws IOException {
        this.reservationNum = reservationNum;
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;

        //creates a new csv file if one doesn't already exist.
        if (!reservationWriterFile.exists()) {
            reservationWriterFile.createNewFile();
        }

        //Prints the data to the reservations.csv file.
        PrintWriter reservationWriter = new PrintWriter(new java.io.FileWriter(reservationWriterFile, true));
        reservationWriter.append(reservationNum + "," + reservationName + "," + reservationType + "," + checkIn + "," + checkOut + "," +
                numberOfRooms + "," + roomType + "\n");
        reservationWriter.close();
    }

    /**
     * This constructor makes a FileWriter object that writes data to payment.csv.
     *
     * @param isItPaid
     * @param totalCost
     * @throws IOException
     */
    public FileWriter(String isItPaid, double totalCost) throws IOException {
        this.isItPaid = isItPaid;
        this.totalCost = totalCost;

        //creates a new csv if it doesn't already exist.
        if (!paymentWriter.exists()) {
            paymentWriter.createNewFile();
        }

        //Prints the data to the csv file.
        PrintWriter costWriter = new PrintWriter(new java.io.FileWriter(paymentWriter, true));
        costWriter.append(isItPaid + "," + totalCost + "\n");
        costWriter.close();
    }

    /**
     * this method removes a specified reservation from the reservations.csv file.
     *
     * @param number
     */
    public static void removeReservation(int number) {
        File file = new File("src/reservations.csv");
        int reservationInt;
        String reservationName;
        String reservationType;
        String checkIn;
        String checkOut;
        String numberOfRooms;
        String roomType;
        String line;
        ArrayList<TempRes> tempStore = new ArrayList<>();

        try {
            //read in the data from the reservations file, creates a TempRes object and stores data in an arraylist of type TempRes.
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] tokens = line.split(",");
                String reservationString = tokens[0];
                reservationInt = Integer.parseInt(reservationString);
                reservationName = tokens[1];
                reservationType = tokens[2];
                checkIn = tokens[3];
                checkOut = tokens[4];
                numberOfRooms = tokens[5];
                roomType = tokens[6];
                TempRes store = new TempRes(reservationInt, reservationName, reservationType, checkIn, checkOut, numberOfRooms, roomType);
                tempStore.add(store);
            }

            //Iterates the array list. if the reservation number is equal to the reservation you want to remove, remove it from the arraylist.
            for (int i = 0; i < tempStore.size(); i++) {
                if (tempStore.get(i).getReservationNum() == number) {
                    tempStore.remove(i);
                    System.out.println("Removed item number: " + number);
                }
            }

            //Formats the arraylist and stores it in a string.
            String tempStoreString = "";
            for (int i = 0; i < tempStore.size(); i++) {
                tempStoreString += (tempStore.get(i).toString());
            }

            //print the stored reservations from the arraylist back to the csv file. This overwrites the original reservations.csv file.
            PrintWriter reservationWriter = new PrintWriter(new java.io.FileWriter(file, false));
            reservationWriter.write(tempStoreString);
            reservationWriter.close();

            //catch for scanner.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("reservations.csv not found");

            //Catch for FileWriter.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to reservations.csv. Make sure file is in place and available");
        }
    }
}