package practice.ocp;

interface Speak {
    void greet();
}

class Kor implements Speak{
    @Override
    public void greet() {
        System.out.println("안녕하세요");
    }
}

class Eng implements Speak{
    @Override
    public void greet() {
        System.out.println("Hello");
    }
}

class Chi implements Speak {
    @Override
    public void greet() {
        System.out.println("니하오");
    }
}

class Speaker{
    Speak speak;

    public Speaker(final Speak speak) {
        this.speak = speak;
    }

    void sayHello() {
        speak.greet();
    }
}

public class OCPExampleAndFactory {
    public static void main(String[] args) {
        Kor kor = new Kor();
        Eng eng = new Eng();
        Chi chi = new Chi();
        Speaker speaker = new Speaker(chi);

        speaker.sayHello();
    }
}
