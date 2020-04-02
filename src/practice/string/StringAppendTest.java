package practice.string;

public class StringAppendTest {
public static void main(String[] args) {
    String str1 = "0" + "1" + "2";
    System.out.println(str1);

    String str2 = "";
    str2 += "0";
    str2 += "1";
    str2 += "2";
    System.out.println(str2);

    String str3 = "";
    for (int i = 0; i < 3; i++) {
        str3 += i;
    }
    System.out.println(str3);

    String str4 = new StringBuilder()
            .append(0)
            .append(1)
            .append(2)
            .toString();
    System.out.println(str4);

    String str5 = ""
            .concat("0")
            .concat("1")
            .concat("2");
    System.out.println(str5);
}
}
