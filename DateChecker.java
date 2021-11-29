import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * @author Dennis Kolomiyets
 * This class is responsible for all methods that use/check-for dates
 */
public class DateChecker {

    /**
     * This static method returns the difference in days between two days as an integer
     * @param start_date
     * @param end_date
     * @return the difference between 2 days 
     */
    static int findDifference(String start_date, String end_date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d1 = dateFormat.parse(start_date);
            Date d2 = dateFormat.parse(end_date);

            long differenceInDays = TimeUnit.MILLISECONDS.toDays(d2.getTime() - d1.getTime());

            if(differenceInDays == 0){
                System.out.println("Same day");
                return 0;
            } else {
                return (int)differenceInDays+1;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This method returns the number of the week as an integer with 3 added on so it can be easily used to access days in hotels.csv
     * @param date
     * @return returns day of the week as an integer from Sun - Sat and adds 3
     */
    public static int getDayNumber(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            Date realDate = dateFormat.parse(date);
            cal.setTime(realDate);
            return cal.get(Calendar.DAY_OF_WEEK)+3;
        } catch (ParseException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This method returns todays date as a String in the dd-mm-yyyy format
     * @return todays date
     */
    public static String getLocalDate() {
        String date = LocalDate.now().toString();
        String[] tokens = date.split("-");
        return tokens[2] + "-" + tokens[1] + "-" + tokens[0];
    }

    /**
     * This method checks every date between 2 given dates, then compares and checks if there are existing reservations for the given room types and dates that fall between the two given dates.
     * It increments each day locally til its gone through the entire reservations.csv file
     * if any of these days exceed the maximum rooms from hotels.csv it returns false
     * otherwise it returns true
     * @param roomType
     * @param checkin
     * @param checkout
     * @return true if a room is available for reservation, else false
     */
    public static boolean checkVacancy(String roomType, String checkin, String checkout) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calender = Calendar.getInstance();


        Map<String, List<TempRes>> reservations = TempRes.loadCSV("CsvFiles/reservations.csv");
        if (reservations == null) {
            return true;
        }

        List<TempRes> r = reservations.get(roomType);
        if (r == null) {
            return true;
        }

        try {
            int daysRequired = findDifference(checkin, checkout);
            ExistingReservation[] occupiedRooms = new ExistingReservation[daysRequired];
            Date in = dateFormat.parse(checkin);
            calender.setTime(in);
            for(int i = 0; i < daysRequired; i++){
                occupiedRooms[i] = new ExistingReservation(calender.getTime(), 0);
                calender.add(Calendar.DATE, 1);
            }

            for (ExistingReservation er : occupiedRooms) {
                for (TempRes res : r) {
                    Date checkIn = dateFormat.parse(res.checkIn);
                    Date checkOut = dateFormat.parse(res.checkOut);
                    if (!er.getReservationDate().after(checkOut) && !er.getReservationDate().before(checkIn)) {
                        er.incrementTotal();
                    }
                }
            }

            for(ExistingReservation er : occupiedRooms) {
                if(er.getReservedTotal() >= FileReader.roomTypeNumberOfRooms(roomType)){
                    return false;
                }
            }
           } catch (Exception e) {
               e.printStackTrace();
           }
        return true;
       }


}



