package practice.reifialbetest;

import java.util.ArrayList;
import java.util.List;

public class ReifiableTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("str1");
        System.out.println("stringList.get(0).toLowerCase() = " + stringList.get(0).toLowerCase());

        String[] strArray = new String[1];
        strArray[0] = "str1";
        System.out.println("strArray[0].toLowerCase() = " + strArray[0].toLowerCase());
    }

    private static void myMethod(List<? extends Number> list) {
        for (Object o : list) {
            System.out.println("o.toString() = " + o.toString());
        }
    }
}
