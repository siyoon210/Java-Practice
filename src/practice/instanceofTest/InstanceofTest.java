package practice.instanceofTest;

public class InstanceofTest {
    public static void main(String[] args) {
        String str = "문자열";
        String strInt = "123";

        System.out.println(((Object)str instanceof Integer)); //false
        System.out.println(((Object)strInt instanceof Integer)); //false

        System.out.println(((Object)str.toString() instanceof Integer)); //false
        System.out.println(((Object)strInt.toString() instanceof Integer)); //false

        //System.out.println(Integer.parseInt(str)); //예외발생
        System.out.println(Integer.parseInt(strInt));

    }
}
