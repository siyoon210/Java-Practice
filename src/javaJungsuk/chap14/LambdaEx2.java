package javaJungsuk.chap14;

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}
public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction f = () -> {
        };
        Object obj = (MyFunction2) (() -> {
        }); //오프젝트 타입으로 형변환이 생략됨
        String str = ((Object)(MyFunction2)(()->{})).toString(); //람다식은 함수형 인터페이스로만 형변환이 가능하다.

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);
        System.out.println((MyFunction) (() -> {
        }));
        System.out.println(((Object) (MyFunction2) (() -> {
        })));
    }
}
