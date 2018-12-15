package javaJungsuk.chap14.exercise14_5;

import java.util.stream.Stream;

//String[] strArr = { "aaa","bb","c", "dddd" }; 의 모든 문자열의 길이를 더한 결과를 출력하라.
public class Exercise14_5 {
    public static void main(String[] args) {
        String[] strArr = { "aaa","bb","c", "dddd" };
        Stream<String> strArrStream = Stream.of(strArr);
        System.out.println(strArrStream.mapToInt(String::length).sum());
    }
}
