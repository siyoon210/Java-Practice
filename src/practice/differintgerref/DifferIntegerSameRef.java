package practice.differintgerref;

class MyInteger{
    int val;

    public MyInteger(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

public class DifferIntegerSameRef {
    public static void main(String[] args) {
        Integer integer1 = 1;
        Integer integer2 = integer1;
        integer2 = 2;

        System.out.println("integer1 + " + integer1);
        System.out.println("integer2 + " + integer2);

        MyInteger myInteger1 = new MyInteger(1);
        MyInteger myInteger2 = myInteger1;

        myInteger2.setVal(2);

        System.out.println(myInteger1.getVal());
        System.out.println(myInteger2.getVal());

        //결론 그냥 Integer 로는 같은 참조로 가르켜도 값이 달리지면 새롭게 인스턴스가 만들어지게 되어 다른 참조들은 영향이 없다.
        //그래서 따로 클래스를 만들어서 하면 가능하다.
    }
}
