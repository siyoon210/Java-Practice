package practice.regularexpression;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("c[a-z]");
        Matcher m = p.matcher("abcdefghijklmnopcace");
//        if (m.matches()) {
//            System.out.println("matches 됨");
//        } else if (m.find()) {
//            System.out.println("find 됨");
//        }

        int count = 0;
        while (m.find()) {
            count++;
        }

        System.out.println("count = " + count);
    }
}
