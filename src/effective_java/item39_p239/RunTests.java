package effective_java.item39_p239;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Sample {
    public static void m1() {
        System.out.println("m1");
    }

    public void m2() {
        System.out.println("m2");
    }
}

public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        final Class<?> aClass = Class.forName("effective_java.item39_p239.Sample");
        Sample sample = new Sample();
        final Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod.getName() = " + declaredMethod.getName());
            declaredMethod.invoke(sample);
        }
    }
}
