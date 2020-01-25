package arrayaslistinstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListInstanceTest {
    public static void main(String[] args) {
        final List<Integer> integers = new ArrayList<>();
        System.out.println("integers.getClass().getTypeName() = " + integers.getClass().getTypeName());
        if (integers instanceof ArrayList) {
            System.out.println("어레이리스트다");
        } else {
            System.out.println("아니다");
        }

        final List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println("list.getClass().getTypeName() = " + list.getClass().getTypeName());
        if (list instanceof ArrayList) {
            System.out.println("어레이리스트다!");
        } else {
            System.out.println("어레이리스트 아니다!");
        }
    }
}
