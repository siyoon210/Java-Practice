package practice.interfacetest.multipleextends;

interface SuperInterface{
    void superMethod();
}

interface SubInterface1 extends SuperInterface{
    void subMethod();

    @Override
    void superMethod();
}

interface SubInterface2 extends SuperInterface{
    int subMethod();

    @Override
    void superMethod();
}

//interface BottomInterface extends SubInterface1, SubInterface2 {
//    @Override
//    void subMethod();
//
//    @Override
//    void superMethod();
//}
public class MultipleExtends {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x);
    }
}
