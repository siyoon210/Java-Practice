package practice.stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MyClass {
    int integer = 0;
}

public class StreamTest {
    static final int TEST_SIZE = 10000;

    public static void main(String[] args) {
        List<Integer> list = getTestLists();

        final MyClass myClass1 = new MyClass();
        final List<Integer> collect1 = list.stream().map(i -> {
            myClass1.integer++;
            return i;
        }).collect(Collectors.toList());

        System.out.println("myClass1.integer = " + myClass1.integer);
        assertThat(myClass1.integer).isEqualTo(TEST_SIZE);

        System.out.println("-----------");

        final MyClass myClass2 = new MyClass();
        final List<Integer> collect2 = list.stream().parallel().map(i -> {
            myClass2.integer++;
            return i;
        }).collect(Collectors.toList());

        System.out.println("myClass2.integer = " + myClass2.integer);
        assertThat(myClass2.integer).isNotEqualTo(TEST_SIZE);
    }

    private static List<Integer> getTestLists() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }
        return list;
    }
}
