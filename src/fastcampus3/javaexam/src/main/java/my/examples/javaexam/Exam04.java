package my.examples.javaexam;

public class Exam04 {
    public static void main(String[] args) {
        Listener listener = new MyListener();
        listener.info();
        listener.listen();
    }
}
