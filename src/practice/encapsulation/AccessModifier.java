package practice.encapsulation;

public class AccessModifier {
    private int a = 10;
    int b = 20; //default는 키워드를 적지 않습니다.
    protected int c = 30;
    public int d = 40;
}

class AmTester {
    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();
        //int a = am.a; //다른 클래스 에서는 접근 불가!
        int b = am.b;
        int c = am.c;
        int d = am.d;
    }
}
