import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author Cael O'Flaherty
 *
 * This class writes data to both payment.csv and reservations.csv.
 */
public class FileWriter {
    File reservationWriterFile = new File("src/reservations.csv");
    File paymentWriter = new File("src/payment.csv");

    private int reservationNum;
    private String reservationName;
    private String reservationType;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private String roomType;


    private String isItPaid;
    private double totalCost;

    /**
     * This constructor makes a FileWriter object that writes data to reservations.csv
     *
     * @param reservationNum
     * @param name
     * @param type
     * @param checkIn
     * @param checkOut
     * @param numberOfRooms
     * @param roomType
     * @throws IOException
     */
    public FileWriter(int reservationNum, String name, String type, String checkIn, String checkOut, int numberOfRooms, String roomType) throws IOException {
        this.reservationNum = reservationNum;
        reservationName = name;
        reservationType = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;

        //converts the arrays to strings



        //creates a new csv if it doesn't already exist
        if (!reservationWriterFile.exists()) {
            reservationWriterFile.createNewFile();
        }

        //Prints the data to the csv file
        PrintWriter reservationWriter = new PrintWriter(new java.io.FileWriter(reservationWriterFile, true));
        reservationWriter.append(reservationNum + "," + reservationName + "," + reservationType + "," + checkIn + "," + checkOut + "," +
                numberOfRooms + "," + roomType + "\n");
        reservationWriter.close();
    }

    /**
     * This constructor makes a FileWriter object that writes data to payment.csv
     * @param isItPaid
     * @param totalCost
     * @throws IOException
     */
    public FileWriter(String isItPaid, double totalCost) throws IOException {
        this.isItPaid = isItPaid;
        this.totalCost = totalCost;

        //creates a new csv if it doesn't already exist
        if (!paymentWriter.exists()) {
            paymentWriter.createNewFile();
        }

        //Prints the data to the csv file
        PrintWriter costWriter = new PrintWriter(new java.io.FileWriter(paymentWriter, true));
        costWriter.append(isItPaid + "," + totalCost + "\n");
        costWriter.close();
    }

    public static void removeReservation(int number){
        System.out.println("Removes item number: " + number);
        //removes the line with the number matching the reservation number in reservation.csv
    }
}
