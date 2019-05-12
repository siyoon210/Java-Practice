package practice.customannotation;
//나만의 애노테이션 만들기
// 1. 애노테이션 선언
// 2. 애노테이션 사용
// + 3. 애노테이션 기능정의하기

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    int repeat() default 10;

    String name() default "정시윤";
}



class MyClass{
    @MyAnnotation(repeat = 5, name = "배대준")
    void sayHello() {
        System.out.println("안녕하세요!");
    }
}


public class CustomAnnotation {
    public static void main(String[] args) throws Exception{
        MyClass myClass = new MyClass();

        Method method = myClass.getClass().getDeclaredMethod("sayHello");

        if (method.isAnnotationPresent(MyAnnotation.class)) {
            for (int i = 0; i < method.getAnnotation(MyAnnotation.class).repeat(); i++) {
                myClass.sayHello();
                System.out.println(method.getAnnotation(MyAnnotation.class).name());
            }
        } else {
            myClass.sayHello();
        }
    }
}
