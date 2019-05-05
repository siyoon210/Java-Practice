package practice.foreachstringarray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForeachStringArray {
    public static void main(String[] args) {
        String[] strArray = {
                "A", "B", "C"
        };

        for (String s : strArray) {
            s = "Hello";
        }

        for (String s : strArray) {
            System.out.println(s);
        }

        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = "" + i;
        }

        for (String s : strArray) {
            System.out.println(s);
        }

        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("B");
        strList.add("C");

        Iterator<String> iterator = strList.iterator();
    }
}
