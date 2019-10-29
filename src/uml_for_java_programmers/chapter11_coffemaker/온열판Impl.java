package uml_for_java_programmers.chapter11_coffemaker;

public class 온열판Impl implements 온열판 {
    public static final int WARMER_EMPTY = 0;
    public static final int POT_EMPTY = 1;
    public static final int POT_NOT_EMPTY = 1;

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
