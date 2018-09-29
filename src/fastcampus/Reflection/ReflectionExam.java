package fastcampus.Reflection;

import java.lang.reflect.Method;

class TestClass{
    private String name;
    private String hello = "hello";

    public TestClass() {
    }

    public String getName() {
        return name;
    }

    public String getHello() {
        return hello;
    }
}
public class ReflectionExam {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("fastcampus.Reflection.TestClass");
        Object o  = c.newInstance();
        //형변환 어케 하는거자ㅣ?

    }
}

