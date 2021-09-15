package practice.datetimeformatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        String yyyy년_mm월_dd일 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        System.out.println("yyyy년_mm월_dd일 = " + yyyy년_mm월_dd일);
    }
}
