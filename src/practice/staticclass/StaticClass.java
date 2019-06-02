package practice.staticclass;

import java.util.List;

class MyClass {
    static List myList;

    class InnerClass{
        void innerClassMethod() {
            MyClass.this.myMethod(); //숨은 외부 참조가 있기 때문에 가능
        }
    }

    static class InnerStaticClass{
        void innerClassMethod() {
//            MyClass.this.myMethod(); //컴파일 에러
        }
    }

    void myMethod() {

    }
}

public class StaticClass {
    public static void main(String[] args) {
        List myList1 = MyClass.myList;
        List myList2 = MyClass.myList;
        if (myList1 == myList2) {
            System.out.println("스태틱 필드는 다 같은 참조");
        } else {
            System.out.println("스태틱 필드라도 다른 참조");
        }

        MyClass.InnerClass mic1 = new MyClass().new InnerClass();
        MyClass.InnerClass mic2 = new MyClass().new InnerClass();
        if (mic1 == mic2) {
            System.out.println("내부 클래스는 새로만들어도 같은 참조지");
        } else {
            System.out.println("내부 클래스도 클래스니까 다른 참조지");
        }

        MyClass.InnerStaticClass misc1 = new MyClass.InnerStaticClass();
        MyClass.InnerStaticClass misc2 = new MyClass.InnerStaticClass();
        if (misc1 == misc2) {
            System.out.println("내부 스태틱 클래스는 새로만들어도 같은 참조지");
        } else {
            System.out.println("내부 스태틱 클래스도 클래스니까 다른 참조지");
        }


        MyClass mc = new MyClass();
        MyClass.InnerClass mic3 = mc.new InnerClass(); //mic3은 "mc에 대한 숨은 외부 참조"를 갖는다.
        MyClass.InnerStaticClass misc3 = new MyClass.InnerStaticClass(); //misc3은 그딴 거 없다.
    }
}
