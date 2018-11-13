package practice.hashcode;

public class HashCode {
    public static void main(String[] args) {
        Integer i = new Integer(10);
        Integer i2 = new Integer(-10);
        System.out.println(i.hashCode());
        System.out.println(i2.hashCode());
        Long l = new Long(20);
        System.out.println(l.hashCode());
        Double d = new Double(10.5);
        System.out.println(d.hashCode());
        String s = new String("hi");
        String s2 = new String("hi");
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());

        if (i.hashCode() == i2.hashCode()) {
            System.out.println("i와 i2의 해쉬코드 값은 같다");
        }
        if (i == i2) {
            System.out.println("i와 i2는 완전히 같은 참조다");
        } else {
            System.out.println("다른 참조다");
        }

        /**결론
         * 1) 정수형 참조변수 Integer,Long의 해쉬코드 값은 밸류와 같다.
         *
         * 2) 다른 참조라도 해쉬코드값은 같을 수 있다. equals는 해쉬코드로만 비교하는 것이 아니였다.
         * */

    }
}
