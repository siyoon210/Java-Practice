package my.examples.javaexam.my;

import my.examples.javaexam.fw.Action;

public class MyAction extends Action {
    @Override
    protected void sevice() {
        System.out.println("Service in my action");
    }
}
