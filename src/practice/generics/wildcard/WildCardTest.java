package practice.generics.wildcard;

import java.util.List;
import java.util.Objects;

public class WildCardTest {
    public static void main(String[] args) {

    }

    private void wildCardTest(List<? extends Number> list, List<? extends Number> list2) {
//        list.add(10);
        list.add(null);

//        Object object = new Object();
//        list.add(object);
    }

    private <T extends Number> void genericMethodTest(List<T> list, List<T> list2) {
        //        list.add(10);
        list.add(null);

//        Object object = new Object();
//        list.add(object);

    }
}
