package practice.wrapperclass;

/**
 * 참조타입의 수의 연산이 되어 새로운 숫자가 되면 다른 객체인가? 같은 객체인가?
 * 스트링은 알고 있었는데, 참조타입도 이렇다니!
 */
public class sumReferenceType {
    public static void main(String[] args) {
        Long num = 0L;
        Long l1 = num;

        num += 1;

        if (l1 == num) {
            System.out.println("숫자가 변해도 같은 참조다.");
        } else {
            System.out.println("숫자가 변하면 다른 참조지!");
        }

        String str = "hello";
        String s1 = str;

        str += " world";

        if (s1 == str) {
            System.out.println("문자가 바뀌어도 같은 참조다.");
        } else {
            System.out.println("문자가 바뀌면 다른 참조지!");
        }
    }
}
