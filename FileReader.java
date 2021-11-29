import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Dennis Kolomiyets
 * This class is responsible for all methods involving the reading of files
 */
public class FileReader {

    /**
     * This static method calculates the total price for booking a particular room from a start date til an end date
     * @param startDate
     * @param endDate
     * @param roomType
     * @return
     */
    public static double getPrice(String startDate, String endDate, String roomType) {
        try {
            String line = "";
            double result = 0;
            java.io.File file = new java.io.File("CsvFiles/hotels.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                String roomTypeName = tokens[0];
                if(roomTypeName.equals(roomType)){
                    int numDays = DateChecker.findDifference(startDate, endDate);
                    int day = DateChecker.getDayNumber(startDate);
                    for(int i = 0; i < numDays; i++){
                        if(day == 11){
                            day = 4;
                        }
                        result = result + Integer.parseInt(tokens[day]);
                        day++;
                    }

                    return result;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This static method returns the number of people to be books for a particular room
     * @param roomType
     * @return
     */
    public static int getMaxOccupancy(String roomType){
        try {
            String line = "";
            java.io.File file = new java.io.File("CsvFiles/hotels.csv");
            Scanner scanner = new Scanner(System.in);
            Scanner fileScanner = new Scanner(file);
            int num = 0;

            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                String[] tokens = line.split(",");
                String roomTypeName = tokens[0];
                if(roomTypeName.equals(roomType)){
                    while(num > Integer.parseInt(tokens[3]) || num <= 0){
                        System.out.println("Input number of Occupants in " + roomType + ". Max Occupancy: " + tokens[3] + "\n");
                        num = Integer.parseInt(scanner.nextLine());
                    }

                    return num;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This static method returns the contents of reservation in the form of a String
     * @return
     */
    public static String readReservations() {
        String line = "";
        String result = "";
        java.io.File file = new java.io.File("CsvFiles/reservations.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                String resNum = tokens[0];
                String resName = tokens[1];
                String resType = tokens[2];
                String checkIn = tokens[3];
                String checkOut = tokens[4];
                String numOfRooms = tokens[5];
                String rooms = tokens[6];
                result = result + "Reservation Number: " + resNum + "\nReservation Name: " + resName + "\nType: " + resType + "\nDuration of stay: " + checkIn + " -> " + checkOut + "\nNumber of Rooms: " + numOfRooms + " Rooms: " + rooms + "\n\n%";

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This static method returns the amount of rows in reservations.csv as an Integer
     * @return
     */
    public static int getListSize(){
        int result = 0;
        String line = "";

        java.io.File file = new java.io.File("CsvFiles/reservations.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                result++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This static method is responsible for checking in
     * where the result is a message stating whether your check-in was successful or not
     * @return
     */
    public static String checkIn(){
        String line = "";
        java.io.File file = new java.io.File("CsvFiles/reservations.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                String checkInDate = tokens[3];
                if(checkInDate.equals(DateChecker.getLocalDate())){
                    return tokens[1] + " has successfully checked in for reservation number: " + tokens[0];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "No Reservations found for today";
    }

    /**
     * This static method returns the reservation number of the last item in reservation.csv
     * @return
     */
    public static int checkLastNumber(){
        String line = "";
        int resNumber = 0;
        java.io.File file = new java.io.File("CsvFiles/reservations.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                resNumber = Integer.parseInt(tokens[0]);
            }
            return resNumber+1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This method returns the maximum number of rooms associated with each room type found in hotels.csv
     * @param roomType
     * @return
     */
    public static int roomTypeNumberOfRooms(String roomType){
        String line = "";
        java.io.File file = new java.io.File("CsvFiles/hotels.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                if(tokens[0].equals(roomType)){
                    return Integer.parseInt(tokens[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This method gets the check-in date for a particular reservation based on the reservation number given from reservations.csv
     * @param number
     * @return
     */
    public static String getCheckIn(int number){
        String line = "";
        java.io.File file = new java.io.File("CsvFiles/reservations.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                if(Integer.parseInt(tokens[0]) == number){
                    return tokens[3];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method gets the reservation type for a particular reservation based on the reservation number given from reservations.csv
     * @param number
     * @return
     */
    public static String getType(int number){
        String line = "";
        java.io.File file = new java.io.File("CsvFiles/reservations.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(",");
                if(Integer.parseInt(tokens[0]) == number){
                    return tokens[2];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
