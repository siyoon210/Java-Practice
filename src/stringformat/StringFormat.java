package stringformat;

public class StringFormat {
    public static void main(String[] args) {
        Integer number = null;
        String hello = String.format("%s_%d", "Hello", number);
        System.out.println(hello);
    }
}
