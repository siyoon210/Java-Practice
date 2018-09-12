package fastcampus.io.file;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.File;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MakeDateDir {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        int day = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);

        String sDate = (day<10) ? "0"+day : ""+day;
        String sMonth = (month<10) ? "0"+month : ""+month;


//        double noMonth = Double.parseDouble(sMonth);
//        int noDate = Integer.parseInt(sDate);
//        System.out.println(noMonth + " " + noDate);

        String path = "."+File.separator+"tmp"+File.separator+year+File.separator+sMonth+File.separator+sDate;
        File file = new File(path);

        file.mkdirs();

        System.out.println("done");
    }
}
