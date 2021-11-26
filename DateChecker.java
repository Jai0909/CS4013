import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class DateChecker {


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
}


