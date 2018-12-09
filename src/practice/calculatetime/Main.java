package practice.calculatetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); //M은 달을 나타내니까 mm으로 하니까 계산 가능하다!
        Date date = null;
        try {
            date = sdf.parse("09:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-1);

        System.out.println(sdf.format(cal.getTime()));

    }
}
