import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Cael O'Flaherty
 * This class handles the analytics of a reservation system. You can get analytics for both income and occupancy per hotel.
 */
public class Analytics {

    /**
     * This method returns the total income in a specified hotel for a specified time frame.
     *
     * @param checkFromDate String, first date you want to check from.
     * @param checkToDate String, date you want to check up until.
     * @param hotel String, the room type. used to find which hotel you want to check.
     * @return double The total income for the hotel and time period specified.
     */
    public static double income(String checkFromDate, String checkToDate, String hotel) {
        double totalIncome = 0;
        ArrayList<TempPay> income = dateChecker(checkFromDate, checkToDate, hotel);

        //If statement specifies whether the hotel is 5 star, 4 star or 3 star using the name of the rooms.
        if (hotel.toLowerCase().contains("deluxe")) { //5 star
            //for loop that calculates the sum of every payment
            for (int i = 0; i < income.size(); i++) {
                totalIncome += income.get(i).getTotalCost();
            }

        } else if (hotel.toLowerCase().contains("executive")) { //4 star
            //for loop that calculates the sum of every payment
            for (int i = 0; i < income.size(); i++) {
                totalIncome += income.get(i).getTotalCost();
            }

        } else { //3 star
            //for loop that calculates the sum of every payment
            for (int i = 0; i < income.size(); i++) {
                totalIncome += income.get(i).getTotalCost();
            }

        }
        return totalIncome;
    }

    /**
     * This method returns the total number of occupants in a specified hotel for a specified time frame.
     *
     * @param checkFromDate String, first date you want to check from.
     * @param checkToDate String, date you want to check up until.
     * @param hotel String, the room type. used to find which hotel you want to check.
     * @return int the number of total occupants.
     */
    public static int occupancy(String checkFromDate, String checkToDate, String hotel) {
        ArrayList<TempPay> occupancy = dateChecker(checkFromDate, checkToDate, hotel);
        int totalOccupancy;

        //If else if statement specifies whether the hotel is 5 star, 4 star or 3 star using the name of the rooms.
        if (hotel.toLowerCase().contains("deluxe")) { //5 star
            totalOccupancy = occupancy.size();
        } else if (hotel.toLowerCase().contains("executive")) { //4 star
            totalOccupancy = occupancy.size();
        } else { //3 star
            totalOccupancy = occupancy.size();
        }
        return totalOccupancy;
    }

    /**
     * This method returns an ArrayList of payments that are contained within the time period of the input parameters from and to date.
     *
     * @param checkFromDate String, first date you want to check from.
     * @param checkToDate String, date you want to check up until.
     * @param hotel String, the room type. used to find which hotel you want to check.
     * @return ArrayList of TempPay objects.
     */
    private static ArrayList<TempPay> dateChecker(String checkFromDate, String checkToDate, String hotel) {
        ArrayList<TempPay> payment = paymentReader();
        ArrayList<TempPay> withinDates = new ArrayList<>();
        String resDatesFrom, resDatesTo, paramDatesFrom, paramDatesTo, tempHotel;
        int finalResDatesFrom, finalResDatesTo, finalParamDatesFrom, finalParamDatesTo, flag;

        //For loop that adds payment details to an arrayList if the dates of payment are within the correct zone.
        for (int i = 0; i < payment.size(); i++) {
            flag = 0;

            //Split the string of payment from dates. add them into String with format yyyymmdd parse it to an integer
            String[] paymentTokensFrom = payment.get(i).getCheckInDate().split("-");
            resDatesFrom = paymentTokensFrom[2] + paymentTokensFrom[1] + paymentTokensFrom[0];
            finalResDatesFrom = Integer.parseInt(resDatesFrom);

            //Split the string of parameter from dates. add them into String with format yyyymmdd, parse it to an integer
            String[] paramTokensFrom = checkFromDate.split("-");
            paramDatesFrom = paramTokensFrom[2] + paramTokensFrom[1] + paramTokensFrom[0];
            finalParamDatesFrom = Integer.parseInt(paramDatesFrom);

            //Split the string of parameter to dates. add them into String with format yyyymmdd, parse it to an integer
            String[] paramTokensTo = checkToDate.split("-");
            paramDatesTo = paramTokensTo[2] + paramTokensTo[1] + paramTokensTo[0];
            finalParamDatesTo = Integer.parseInt(paramDatesTo);

            // if else statement that converts the room type to the correct format for dateChecker. eg. "Deluxe standard" becomes "deluxe"
            if (payment.get(i).getRoomTypeForHotel().toLowerCase().contains("deluxe")) {
                tempHotel = "deluxe";
            } else if (payment.get(i).getRoomTypeForHotel().toLowerCase().contains("executive")) {
                tempHotel = "executive";
            } else {
                tempHotel = "classic";
            }

            //Compare the from value between payment date and parameter to and from date. If they are in range and if the correct
            //hotel type is chosen increment flag.
            if (finalResDatesFrom >= finalParamDatesFrom && finalResDatesFrom <= finalParamDatesTo &&
                    tempHotel.equals(hotel.toLowerCase())) {
                flag++;
            }

            //Split the string of payment to dates. add them into String with format yyyymmdd parse it to an integer
            String[] paymentTokensTo = payment.get(i).getCheckOutDate().split("-");
            resDatesTo = paymentTokensTo[2] + paymentTokensTo[1] + paymentTokensTo[0];
            finalResDatesTo = Integer.parseInt(resDatesTo);

            //Compare the to value between payment date and parameter to and from date. If they are in range and if the correct
            //hotel type is chosen, increment flag.
            if (finalResDatesTo >= finalParamDatesFrom && finalResDatesTo <= finalParamDatesTo &&
                    tempHotel.equals(hotel.toLowerCase())) {
                flag++;
            }

            //If both previous date checks are true, add that specific payment date to the returned arraylist of dates within range.
            if (flag == 2) {
                withinDates.add(payment.get(i));
            }
        }
        return withinDates;
    }

    /**
     * This method returns an arrayList of type tempPay with all payments inside it.
     *
     * @return ArrayList of TempPay objects.
     */
    private static ArrayList<TempPay> paymentReader() {
        File file = new File("CsvFiles/payment.csv");
        int resNum;
        String checkInDate;
        String checkOutDate;
        String roomTypeForHotel;
        double totalCost;
        String line;
        ArrayList<TempPay> tempPay = new ArrayList<>();

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
                tempPay.add(store);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("payments.csv not found");
        }
        return tempPay;
    }
}
