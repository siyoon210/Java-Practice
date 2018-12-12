package javaJungsuk.chap14.exercise14_2;

//메소드 참조로 바꾸기
public class Exercise14_2 {
    //(String s) -> s.length()
    //String::length

    //()-> new int[]{}
    //변환불가 (X) int[]::new

    //arr -> Arrays.stream(arr)
    //Arrays::stream

    //(String str1, String str2) -> str1.equals(str2)
    //String::equals

    //(a,b)->Integer.compare(a,b)
    //Integer::compare

    //(String kind, int num) -> new Card(kind, num)
    //변환불가 (X) -> Card::new

    //(x) -> System.out.println(x)
    //변환불가 (X) -> System.out::println

    //() -> Math.random()
    //Math::random

    //(str) -> str.toUpperCase()
    //String::toUppperCase

    //() -> new NullPointerException()
    //NullPointerException::new

    //(Optional opt) -> opt.get()
    //Optionlal::get

    //(StringBuffer sb, String s) -> sb.append(s)
    //StringBuffer::append

    //(String s) -> System.out.println(s)
    //System.out::println


}
