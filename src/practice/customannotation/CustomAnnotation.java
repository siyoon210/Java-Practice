package practice.customannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
}

class MyClass{
    @MyAnnotation
    void hello() {
        System.out.println("안녕하세요~!");
    }
}


public class CustomAnnotation {
    public static void main(String[] args) throws Exception{
        MyClass myClass = new MyClass();

        Method method = myClass.getClass().getDeclaredMethod("hello");

        if (method.isAnnotationPresent(MyAnnotation.class)) {
            for (int i = 0; i < 10; i++) {
                myClass.hello();
            }
        } else {
            myClass.hello();
        }
    }
}
