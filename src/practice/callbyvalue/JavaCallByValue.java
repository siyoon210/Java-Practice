package practice.callbyvalue;

//자바는 메소드에 인자로 객체를 가르키는 참조 값을 전달한다.
//그래서 참조하는 객체의 값은 바꿀 수 있다.
//하지만 참조값 자체를 바꿀 순 없다.
class MyClass{
    int index;

    public MyClass(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

public class JavaCallByValue {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        swap(a,b);
        System.out.println(a);
        System.out.println(b);

        MyClass myClass1 = new MyClass(1);
        MyClass myClass2 = new MyClass(2);
        System.out.println("myClass1의 인덱스값 : "+myClass1.getIndex());
        System.out.println("myClass2의 인덱스값 : "+myClass2.getIndex());

        //두개의 참조를 바꿔 보자
        swapReference(myClass1, myClass2);
        System.out.println("myClass1의 인덱스값 : "+myClass1.getIndex());
        System.out.println("myClass2의 인덱스값 : "+myClass2.getIndex());

        //두개의 내부 값을 바꿔 보자
        swapValue(myClass1, myClass2);
        System.out.println("myClass1의 인덱스값 : "+myClass1.getIndex());
        System.out.println("myClass2의 인덱스값 : "+myClass2.getIndex());

        //그냥은 바뀐다.
        System.out.println("그냥 참조를 바꿔보자!");
        MyClass tmp = myClass1;
        myClass1 = myClass2;
        myClass2 = tmp;
        System.out.println("myClass1의 인덱스값 : "+myClass1.getIndex());
        System.out.println("myClass2의 인덱스값 : "+myClass2.getIndex());
    }

    static void swapReference(MyClass m1, MyClass m2) {
        System.out.println("메소드의 인수로 받아서 참조를 바꿔보자!");
        MyClass tmp = m1;
        m1 = m2;
        m2 = tmp;
    }

    static void swapValue(MyClass m1, MyClass m2) {
        System.out.println("메소드의 인수로 받아서 값을 바꿔보자!");
        int tmpIndex = m1.getIndex();
        m1.setIndex(m2.getIndex());
        m2.setIndex(tmpIndex);
    }

    static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}

