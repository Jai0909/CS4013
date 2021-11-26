import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileWriter {
    File reservationWriterFile = new File("src/reservations.csv");
    File paymentWriter = new File("src/payment.csv");

    private int reservationNum;
    private String reservationName;
    private String reservationType;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private String[] roomType;
    private int[] numOfPeople;
    String roomTypesArray;
    String numOfPeopleArray;

    private String isItPaid;
    private double totalCost;

    public FileWriter(int reservationNum, String name, String type, String checkIn, String checkOut, int numberOfRooms, String[] roomType,
                      int[] numOfPeople) throws IOException {
        this.reservationNum = reservationNum;
        reservationName = name;
        reservationType = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;
        this.numOfPeople = numOfPeople;

        roomTypesArray = Arrays.toString(roomType);
        numOfPeopleArray = Arrays.toString(numOfPeople);

        roomTypesArray = roomTypesArray.replace("[", "");
        roomTypesArray = roomTypesArray.replace("]", "");
        numOfPeopleArray = numOfPeopleArray.replace("[", "");
        numOfPeopleArray = numOfPeopleArray.replace("]", "");

        if (!reservationWriterFile.exists()) {
            reservationWriterFile.createNewFile();
        }

        PrintWriter reservationWriter = new PrintWriter(new java.io.FileWriter(reservationWriterFile, true));
        reservationWriter.append(reservationNum + "," + reservationName + "," + reservationType + "," + checkIn + "," + checkOut + "," +
                numberOfRooms + "," + roomTypesArray + "," + numOfPeopleArray + "\n");
        reservationWriter.close();
    }

    public FileWriter(String isItPaid, double totalCost) throws IOException {
        this.isItPaid = isItPaid;
        this.totalCost = totalCost;

        if (!paymentWriter.exists()) {
            paymentWriter.createNewFile();
        }

        PrintWriter costWriter = new PrintWriter(new java.io.FileWriter(paymentWriter, true));
        costWriter.append(isItPaid + "," + totalCost + "\n");
        costWriter.close();
    }
}