package javaJungsuk.chap14.exercise14_6;

import java.util.Comparator;
import java.util.stream.Stream;

//String[] strArr = { "aaa","bb","c", "dddd" }; 의 모든 문자열의 길이중 제일 긴것을 출력.
public class Exercise14_6 {
    public static void main(String[] args) {
        String[] strArr = { "aaa","bb","c", "dddd" };

        Stream<String> strArrStream = Stream.of(strArr);
        System.out.println(strArrStream.mapToInt(String::length).max().getAsInt());

        strArrStream = Stream.of(strArr);
        strArrStream.map(String::length).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);

    }
}
