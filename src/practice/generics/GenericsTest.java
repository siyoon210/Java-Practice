package practice.generics;

import java.util.ArrayList;

public class GenericsTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("홍길동");
        list.add(100); //이 리스트는 어떤 타입이든 담을 수 있다.


        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("String");
        //list2.add(100); //String만 받기로 되어있어서 숫자는 담을 수 없다.

        MyClass<String> myClass = new MyClass<String>();
//        MyClass2<String> myClass2 = new MyClass2<String>(); //Number와 그의 자손이 아니면 사용 할 수 없음

        myMethod2(myClass);
        //myMethod3(myClass);
    }

//    public void myMethod1(MyClass<T extends Number> myClass) { //T라는 키워드는 메소드 선언당시 아예 안됨 T는 제네릭 클래스를 선언할때 타입변수 제한을 쓸떄 사용한다.
//    }

    public static void myMethod2(MyClass<? extends String> myClass) {
    }

    public static <T extends Number> void myMethod3(MyClass<T> myClass) {

    }
}

class MyClass<T>{ //타입변수로 아무거나 다받음

}

class MyClass2<T extends Number>{ //타입변수로 Number의 자손들만 받음

}
