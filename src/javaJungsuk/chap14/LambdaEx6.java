package javaJungsuk.chap14;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class KanbdaEx6 {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> (int) (Math.random() * 100) + 1;
        IntConsumer intConsumer = i -> System.out.println(i + ", ");
        IntPredicate intPredicate = i -> i % 2 == 0;
        IntUnaryOperator intUnaryOperator = i -> i / 10 % 10;

        int[] arr = new int[10];
    }

    public static makeRandomList(IntSupplier intSupplier, int[] arr) {
        
    }
}
