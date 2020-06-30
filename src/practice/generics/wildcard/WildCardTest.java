package practice.generics.wildcard;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class WildCardTest {
    public static void main(String[] args) {

    }

    private void wildCardTest(List<? extends Number> list, List<? extends Set<Number>> list2) {
//        list.add(10);
        list.add(null);

//        Object object = new Object();
//        list.add(object);

//        list.add(list.get(0));
    }

    private <T extends Number> void genericMethodTest(List<T> list, List<T> list2) {
//        list.add(10);
        list.add(null);

//        Object object = new Object();
//        list.add(object);

        list.add(list.get(0));
    }
}
