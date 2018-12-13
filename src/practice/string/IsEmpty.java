package practice.String;

import java.util.ArrayList;

public class IsEmpty {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = "";

        //isEmpty는 length가 0이면 트루다
        //System.out.println("null은 비어있다고 판단하니? : "+str1.isEmpty()); //nullpointExeption 발생
        System.out.println("\"\"은 비어있다고 판단하니? : "+str2.isEmpty()); //true

    }
}