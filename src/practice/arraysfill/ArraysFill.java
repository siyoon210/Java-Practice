package practice.arraysfill;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysFill {
    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        Arrays.fill(integers, 777);

        for (Integer integer : integers) {
            assertThat(integer).isEqualTo(777);
        }

        System.out.println("Arrays Fill :)");
    }
}
