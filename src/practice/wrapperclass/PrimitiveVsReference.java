package practice;

public class primitivevsreference {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        if (i1 == i2) {
            System.out.println("같은 참조");
        } else {
            System.out.println("다른 참조");
        }
    }
}
