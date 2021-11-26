import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileWriter {
    File toBeWritten = new File("src/reservations.csv");
    private int reservationNum;
    private String reservationName;
    private String reservationType;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private String[] roomType;
    private int[] numOfPeople;
    private double totalCost;
    String roomTypesArray;
    String numOfPeopleArray;

    public FileWriter(int reservationNum, String name, String type, String checkIn, String checkOut, int numberOfRooms, String[] roomType,
                      int[] numOfPeople, double totalCost) throws IOException {
        this.reservationNum = reservationNum;
        reservationName = name;
        reservationType = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;
        this.numOfPeople = numOfPeople;
        this.totalCost = totalCost;

        roomTypesArray = Arrays.toString(roomType);
        numOfPeopleArray = Arrays.toString(numOfPeople);
        /*
        for (int i = 0; i < roomType.length; i++) {
            roomTypesArray += roomType[i] + " ";
        }
        for (int i = 0; i < numOfPeople.length; i++) {
            numOfPeopleArray += numOfPeople[i] + " ";
        }
         */

        PrintWriter writer = new PrintWriter(new java.io.FileWriter(toBeWritten, true));
        writer.append(reservationNum + ", " + reservationName + ", " + reservationType + ", " + checkIn + ", " + checkOut + ", " +
                numberOfRooms + ", " + roomTypesArray + ", " + numOfPeopleArray + ", " + totalCost + "\n");

        writer.close();
    }
}