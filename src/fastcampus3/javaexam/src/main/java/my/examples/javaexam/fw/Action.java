package my.examples.javaexam.fw;

public abstract class Action {
    void init(){
        System.out.println("init");
    }
    protected abstract void sevice();
    void destroy(){
        System.out.println("destory");
    }

    public final void run() {
        init();
        sevice();
        destroy();
    }
}
