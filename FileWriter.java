import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Cael O'Flaherty
 * This class writes data to payment.csv and reservations.csv. It also removes a reservation or a payment from their respective csv file.
 */
public class FileWriter {
    //Reservation csv writer data fields.
    private File reservationWriterFile = new File("CsvFiles/reservations.csv");
    private int reservationNum;
    private String reservationName;
    private String reservationType;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private String roomType;

    //Payment csv writer data fields.
    private File paymentWriter = new File("CsvFiles/payment.csv");
    private int resNum;
    private String checkInDate;
    private String checkOutDate;
    private String roomTypeForHotel;
    private double totalCost;

    /**
     * This constructor makes a FileWriter object that writes data to reservations.csv.
     *
     * @param reservationNum int, reservation number.
     * @param reservationName String, name of reservation.
     * @param reservationType String, type of reservation S or AP.
     * @param checkIn String, date of check in.
     * @param checkOut String, date of check out.
     * @param numberOfRooms int, the number of rooms ou wish to reserve.
     * @param roomType String, the name of the room type you wish to book e.g. deluxe standard
     */
    public FileWriter(int reservationNum, String reservationName, String reservationType, String checkIn, String checkOut, int numberOfRooms,
                      String roomType) {
        this.reservationNum = reservationNum;
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;

        //creates a new csv file if one doesn't already exist.
        if (!reservationWriterFile.exists()) {
            try {
                reservationWriterFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Unable to access file \"reservations.csv\"");
            }
        }

        //Prints the data to the reservations.csv file.
        PrintWriter reservationWriter = null;
        try {
            reservationWriter = new PrintWriter(new java.io.FileWriter(reservationWriterFile, true));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to reservations.csv. Make sure file is in place and available for use");
        }
        reservationWriter.append(reservationNum + "," + reservationName + "," + reservationType + "," + checkIn + "," + checkOut + "," +
                numberOfRooms + "," + roomType + "\n");
        reservationWriter.close();
    }

    /**
     * This constructor makes a FileWriter object that writes data to payment.csv.
     *
     * @param resNum int, the reservation number.
     * @param checkInDate String, date of check in.
     * @param checkOutDate String, date of check out.
     * @param roomTypeForHotel String, name of room you will be staying in e.g. deluxe standard.
     * @param totalCost double, the total cost of your reservation.
     */
    public FileWriter(int resNum, String checkInDate, String checkOutDate, String roomTypeForHotel, double totalCost) {
        this.resNum = resNum;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomTypeForHotel = roomTypeForHotel;
        this.totalCost = totalCost;

        //creates a new csv if it doesn't already exist.
        if (!paymentWriter.exists()) {
            try {
                paymentWriter.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Unable to access file \"payment.csv\"");
            }
        }

        //Prints the data to the csv file.
        PrintWriter costWriter = null;
        try {
            costWriter = new PrintWriter(new java.io.FileWriter(paymentWriter, true));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to payment.csv. Make sure file is in place and available for use");
        }
        costWriter.append(resNum + "," + checkInDate + "," + checkOutDate + "," + roomTypeForHotel + "," + totalCost + "\n");
        costWriter.close();
    }


    /**
     * this method removes a specified reservation from the reservations.csv file.
     *
     * @param number int, the id number of the reservation you wish to remove.
     */
    public static void removeReservation(int number) {
        File file = new File("CsvFiles/reservations.csv");
        int reservationInt;
        String reservationName;
        String reservationType;
        String checkIn;
        String checkOut;
        int numberOfRooms;
        String roomType;
        String line;
        ArrayList<TempRes> tempStore = new ArrayList<>();

        try {
            //read in the data from the reservations file, creates a TempRes object and stores data in an arraylist of type TempRes.
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] tokens = line.split(",");
                reservationInt = Integer.parseInt(tokens[0]);
                reservationName = tokens[1];
                reservationType = tokens[2];
                checkIn = tokens[3];
                checkOut = tokens[4];
                numberOfRooms = Integer.parseInt(tokens[5]);
                roomType = tokens[6];

                TempRes store = new TempRes(reservationInt, reservationName, reservationType, checkIn, checkOut, numberOfRooms, roomType);
                tempStore.add(store);
            }

            //Iterates the array list. if the reservation number is equal to the reservation you want to remove, remove it from the arraylist.
            for (int i = 0; i < tempStore.size(); i++) {
                if (tempStore.get(i).getReservationNum() == number) {
                    tempStore.remove(i);
                    System.out.println("Removed reservation number: " + number);
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

            //Catch for scanner.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("reservations.csv not found");

            //Catch for FileWriter.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to reservations.csv. Make sure file is in place and available for use");
        }
    }


    /**
     * this method removes a specified payment from the payment.csv file.
     *
     * @param number int, the id number of the payment you wish to remove.
     */
    public static void removePayment(int number) {
        File file = new File("CsvFiles/payment.csv");
        int resNum;
        String checkInDate;
        String checkOutDate;
        String roomTypeForHotel;
        double totalCost;
        String line;
        ArrayList<TempPay> tempPayStore = new ArrayList<>();

        try {
            //read in the data from the payment file, creates a TempPay object and stores data in an arraylist of type TempPay.
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] tokens = line.split(",");
                String resNumString = tokens[0];
                resNum = Integer.parseInt(resNumString);
                checkInDate = tokens[1];
                checkOutDate = tokens[2];
                roomTypeForHotel = tokens[3];
                String totalCostString = tokens[4];
                totalCost = Double.parseDouble(totalCostString);

                TempPay store = new TempPay(resNum, checkInDate, checkOutDate, roomTypeForHotel, totalCost);
                tempPayStore.add(store);
            }

            //Iterates the array list. if the reservation number is equal to the reservation number of the payment you want to remove,
            //remove it from the arraylist.
            for (int i = 0; i < tempPayStore.size(); i++) {
                if (tempPayStore.get(i).getReservationNum() == number) {
                    tempPayStore.remove(i);
                    System.out.println("Removed payment for reservation number: " + number);
                }
            }

            //Formats the arraylist and stores it in a string.
            String tempPayStoreString = "";
            for (int i = 0; i < tempPayStore.size(); i++) {
                tempPayStoreString += (tempPayStore.get(i).toString());
            }

            //print the stored payment from the arraylist back to the csv file. This overwrites the original payment.csv file.
            PrintWriter reservationWriter = new PrintWriter(new java.io.FileWriter(file, false));
            reservationWriter.write(tempPayStoreString);
            reservationWriter.close();

            //Catch for scanner.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("payment.csv not found");

            //Catch for FileWriter.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to write to payment.csv. Make sure file is in place and available for use");
        }
    }
}
