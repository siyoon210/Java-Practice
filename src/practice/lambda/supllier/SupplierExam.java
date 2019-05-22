package practice.lambda.supllier;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 1. Supplier 는 입력값 없이 반환값만 존재하는 함수형 인터페이스다.
 * 2. T get() 메소드가 있다.
 *
 * http://www.java2s.com/Tutorials/Java/java.util.function/Supplier/index.htm 참고 사이트
 */
public class SupplierExam {
    public static void main(String[] args) {
        바로_선언해서_get으로_부르기();

        인자로_서플라이어를_사용하는_함수_호출하기();

        new연산자를_서플라이어로_사용하기();

        조건에_부합하는_메소드를_서플라이어로_사용하기();
    }
    //--- 1번 --//
    private static void 바로_선언해서_get으로_부르기() {
        Supplier<String> i = () -> "Hello Supplier";
        System.out.println(i.get());
    }

    //--- 2번 --//
    private static void 인자로_서플라이어를_사용하는_함수_호출하기() {
        SunPower sunPower = new SunPower();

        SunPower p1 = produce(() -> sunPower); //이미 위에서 만들어진걸 리턴하니까 계속 같은 인스턴스다.
        SunPower p2 = produce(() -> sunPower);

        System.out.println("같은 인스턴스인가?" + Objects.equals(p1, p2));
    }

    private static SunPower produce(Supplier<SunPower> sunPowerSupplier) {
        return sunPowerSupplier.get();
    }

    //--- 3번 --//
    private static void new연산자를_서플라이어로_사용하기() {
        SunPower e1 = maker(SunPower::new); //매번 새로운 인스턴스를 생성해서 준다.
        SunPower e2 = maker(SunPower::new);

        System.out.println("Objects.equals(e1, e2) = " + Objects.equals(e1, e2));
    }

    private static SunPower maker(Supplier<SunPower> sunPowerSupplier) {
        return sunPowerSupplier.get();
    }

    //--- 4번 --//
    private static void 조건에_부합하는_메소드를_서플라이어로_사용하기() { //조건이란 인풋없고 반환값만 존재하는 메소드
        Supplier<SunPower> sunPowerSupplier = SupplierExam::sunPowerMaker;

        System.out.println("sunPowerSupplier.get() = " + sunPowerSupplier.get());
        System.out.println("sunPowerSupplier.get() = " + sunPowerSupplier.get());
        System.out.println("sunPowerSupplier.get() = " + sunPowerSupplier.get());
    }

    private static SunPower sunPowerMaker() {
        return new SunPower();
    }
}

class SunPower {
    //기본 생성자 -> 기본 생성자도 입력값 없이 반환값만 존재하니까 서플라이의 식으로 만족된다.
    public SunPower() {
        System.out.println("SunPower 인스턴스 생성");
    }
}