package practice.wrapperclass;

public class PrimitiveVsReference {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(128);//127까진 캐시로 같은 참조 이지만 128부턴 다른 참조다.
        Integer i2 = Integer.valueOf(128);

        int i = Integer.valueOf(1);
        Integer integer = i;

        System.out.println("i = " + i);
        System.out.println("integer = " + integer);

        String s1 = "hello";
        String s2 = "hello";


        if (i1 == i2) {
            System.out.println("같은 참조");
        } else {
            System.out.println("다른 참조");
        }

        if (s1 == s2) {
            System.out.println("같은 참조");
        } else {
            System.out.println("다른 참조");
        }
    }
}
