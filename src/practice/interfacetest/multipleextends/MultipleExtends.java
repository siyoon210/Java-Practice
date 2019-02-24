package practice.interfacetest.multipleextends;

interface GrandFather {
    default void myMethod(){
        System.out.println("GrandFather");
    };
}

interface FatherA extends GrandFather {
    @Override
    default void myMethod(){
        System.out.println("FatherA");
    }
}

interface FatherB extends GrandFather {
    @Override
    default void myMethod(){
        System.out.println("FatherB");
    }
}

//interface Son extends FatherA, FatherB{
//
//}


public class MultipleExtends {
    public static void main(String[] args) {

    }
}
