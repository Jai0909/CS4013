import java.io.FileNotFoundException;
import java.nio.file.LinkPermission;
import java.util.Scanner;

public class FileReader {

    public static double getPrice(String startDate, String endDate, String roomType) {
        try {
            String line = "";
            double result = 0;
            java.io.File file = new java.io.File("src/hotels.csv");
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

    public static int getMaxOccupancy(String roomType){
        try {
            String line = "";
            java.io.File file = new java.io.File("src/hotels.csv");
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

    public static String readReservations() {
        String line = "";
        String result = "";
        java.io.File file = new java.io.File("src/reservations.csv");
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
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }

    public static int getListSize(){
        int result = 0;
        String line = "";

        java.io.File file = new java.io.File("src/reservations.csv");
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

}
