package javaJungsuk.chap14;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class LambdaEx6 {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> (int) (Math.random() * 100) + 1;
        IntConsumer intConsumer = i -> System.out.println(i + ", ");
        IntPredicate intPredicate = i -> i % 2 == 0;
        IntUnaryOperator intUnaryOperator = i -> i / 10 % 10;

        int[] arr = new int[10];
    }

    public static void makeRandomList(IntSupplier intSupplier, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = intSupplier.getAsInt(); //get()이 아니라 getAsInt()임에 주의
        }
    }

    public static void printEvenNum(IntPredicate intPredicate, IntConsumer intConsumer, int[] arr) {
        System.out.println("[");
        for (int i : arr) {
            if (intPredicate.test(i)) {
                intConsumer.accept(i);
            }
        }
        System.out.println("]");
    }

    public static int[] doSomething(IntUnaryOperator intUnaryOperator, int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = intUnaryOperator.applyAsInt(arr[i]);
        }

        return newArr;

    }
}
