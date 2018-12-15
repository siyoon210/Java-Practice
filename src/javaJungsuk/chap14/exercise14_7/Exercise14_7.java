package javaJungsuk.chap14.exercise14_7;

import java.util.Random;
import java.util.stream.IntStream;

//1~45의 임의의 번호중 6개를 출력하시오.
public class Exercise14_7 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(1,46);
        intStream.distinct().limit(6).sorted().forEach(System.out::println);
    }
}
