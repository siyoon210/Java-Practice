package fastcampus3.javaexam.src.main.java.my.examples.javaexam;

public class GenericBox<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }
    public T get() {
        return obj;
    }
}
