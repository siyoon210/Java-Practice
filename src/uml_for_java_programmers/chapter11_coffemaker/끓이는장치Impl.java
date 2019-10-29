package uml_for_java_programmers.chapter11_coffemaker;

public class 끓이는장치Impl implements 끓이는장치 {
    public static final int BOILER_EMPTY = 0;
    public static final int BOILER_NOT_EMPTY = 1;

    private int status;

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }
}
