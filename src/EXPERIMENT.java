import jdk.swing.interop.SwingInterOpUtils;

import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EXPERIMENT {
    public static void main(String[] args) {
        int a = 0;
        long time = System.currentTimeMillis();
        System.out.println(time);
        for (int i = 0; i < 10000000; i++) {
            a += i;
        }
        System.out.println(a);
        long time1 = System.currentTimeMillis();
        System.out.println(time1);

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        Date date1 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        System.out.println(date1);
        System.out.println(date1.getTime());
        System.out.println(date1.before(date));

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        calendar.set(Calendar.SECOND, 25);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.YEAR, 2017);
        int yearNow = calendar.get(Calendar.YEAR);
        System.out.println(calendar);
        System.out.println("asf");
        System.out.println(Calendar.YEAR);
        System.out.println(yearNow);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.get(Calendar.YEAR));
        System.out.println(calendar1);
        calendar1.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
        int dayOfYear = calendar1.get(Calendar.DAY_OF_YEAR);
        System.out.println(dayOfYear);
        Calendar calendar2 = Calendar.getInstance();
        if(calendar2.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
            System.out.println("tuesday");

        }
        Date date2 = new Date();
        System.out.println(calendar2.getTimeInMillis());
        System.out.println(calendar2.getTime());

        String dateString = "16.11.2017";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date4 = simpleDateFormat.parse(dateString);
            System.out.println(date4);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}

