package practice.colletionequlas;

import java.util.HashSet;
import java.util.Set;

public class CollectionEqualsTest {
    public static void main(String[] args) {
        Set<Integer> integers1 = new HashSet<>();
        integers1.add(1);
        integers1.add(200);
        integers1.add(210);

        Set<Integer> integers2 = new HashSet<>();
        integers2.add(1);
        integers2.add(200);
        integers2.add(210);

        if (integers1.equals(integers2)) {
            System.out.println("동등하다.");
        } else {
            System.out.println("동등하지 않다.");
        }
    }
}
