package javaJungsuk.chap14.exercise14_2;

//메소드 참조로 바꾸기
public class Exercise14_2 {
    //(string s) -> s.length()
    //string::length

    //()-> new int[]{}
    //변환불가 (X) int[]::new

    //arr -> Arrays.stream(arr)
    //Arrays::stream

    //(string str1, string str2) -> str1.equals(str2)
    //string::equals

    //(a,b)->Integer.compare(a,b)
    //Integer::compare

    //(string kind, int num) -> new Card(kind, num)
    //변환불가 (X) -> Card::new

    //(x) -> System.out.println(x)
    //변환불가 (X) -> System.out::println

    //() -> Math.random()
    //Math::random

    //(str) -> str.toUpperCase()
    //string::toUppperCase

    //() -> new NullPointerException()
    //NullPointerException::new

    //(Optional opt) -> opt.get()
    //Optionlal::get

    //(StringBuffer sb, string s) -> sb.append(s)
    //StringBuffer::append

    //(string s) -> System.out.println(s)
    //System.out::println


}
