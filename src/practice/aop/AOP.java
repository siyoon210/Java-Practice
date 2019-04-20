package practice.aop;

interface Hello{
    void sayHello(String name);
}

class HelloImpl implements Hello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}

class HelloProxy implements Hello{
    Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("메소드 시작");
        hello.sayHello(name);
        System.out.println("메소드 끝");
    }
}

public class AOP {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        Hello helloProxy = new HelloProxy(hello);

        helloProxy.sayHello("시윤");
    }
}
