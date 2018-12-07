package my.examples.javaexam;

public interface Listener {
    default void info() {
        System.out.println("Listener 입니다.");
    }
    void listen();
}
