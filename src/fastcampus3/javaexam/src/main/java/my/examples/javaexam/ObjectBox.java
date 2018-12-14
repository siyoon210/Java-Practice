package fastcampus3.javaexam.src.main.java.my.examples.javaexam;

public class ObjectBox {
    private Object object;

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }
}

//아무것도 상속받지 않으면 자동으로 Object를 상속받는다.
//public class ObjectBox
//public class ObjectBOx extends Object
