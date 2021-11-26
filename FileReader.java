import java.io.FileNotFoundException;
import java.nio.file.LinkPermission;
import java.util.Scanner;

public class FileReader {
    public static double getPrice(String startDate, String endDate, String roomType) {
        try {
            String line = "";
            double result = 0;
            java.io.File file = new java.io.File("src/hotels.csv");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                line = input.nextLine();
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
                    input.close();
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
            double result = 0;
            java.io.File file = new java.io.File("src/hotels.csv");
            Scanner scanner = new Scanner(System.in);
            Scanner input = new Scanner(file);
            int num = 0;

            while (input.hasNextLine()) {
                line = input.nextLine();
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

}
