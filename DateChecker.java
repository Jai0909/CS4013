import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class DateChecker {
    
    private String arrivaldate;
    private String departuredate;
    
    public DateChecker(){
    }
    
    static int findDifference(String start_date, String end_date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy");

        try {
            Date d1 = dateFormat.parse(start_date);
            Date d2 = dateFormat.parse(end_date);

            long differenceInDays = TimeUnit.MILLISECONDS.toDays(d2.getTime() - d1.getTime());

            if(differenceInDays == 0){
                return 0;
            } else {
                return (int)differenceInDays;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

