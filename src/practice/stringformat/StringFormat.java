package practice.stringformat;

public class StringFormat {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        final String format = String.format("[%s] %s", s1, s2 == null ? "" : s2); //null인경우 문자그대로 null이 찍힘
        System.out.println("format = " + format);
    }
}
