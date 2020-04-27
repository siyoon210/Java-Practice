package practice.ocp;

import java.util.Scanner;

interface Speak {
    void greet();
}

class Kor implements Speak {
    @Override
    public void greet() {
        System.out.println("안녕하세요");
    }
}

class Eng implements Speak {
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

class Speaker {
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
        while (true) {
            Speaker speaker = new Speaker(getSpeak());
            speaker.sayHello();
        }
    }

    private static Speak getSpeak() {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

        while (true) {
            switch (next) {
                case "k":
                    return new Kor();
                case "e":
                    return new Eng();
                case "c":
                    return new Chi();
                default:
                    System.out.println("k, e, c 중에 하나만 입력");
            }
        }
    }
}
