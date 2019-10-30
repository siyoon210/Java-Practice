package uml_for_java_programmers.chapter11_coffemaker.mypractice;

public class 가열기 {
    private 가열Listener listener;

    public 가열기(가열Listener listener) {
        this.listener = listener;
    }

    public void 스위치on() {
        listener.on();
    }

    public void 스위치off() {
        listener.off();
    }
}
