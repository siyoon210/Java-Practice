package practice.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("c[a-z]");
        Matcher m = p.matcher("abcdefghijklmnop");
        if (m.matches()) {
            System.out.println("matches 됨");
        } else if (m.find()) {
            System.out.println("find 됨");
        }
    }
}
