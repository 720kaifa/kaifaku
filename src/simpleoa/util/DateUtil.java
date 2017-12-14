package simpleoa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Luwer on 2017/12/11.
 */
public class DateUtil {
    public static int GetWeekDate(String dateString,String formatString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        Calendar cal = Calendar.getInstance();
        Date upt=df.parse(dateString);
        cal.setTime(upt);
        int
                weekDate=cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println(weekDate);
        return weekDate;
    }

    public static int GetMonthDate(String dateString,String formatString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        Calendar cal = Calendar.getInstance();
        Date upt=df.parse(dateString);
        cal.setTime(upt);
        int monthDate=cal.get(Calendar.MONTH)+1;
        System.out.println(monthDate);
        return monthDate;
    }
}
