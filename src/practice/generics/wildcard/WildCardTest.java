package practice.generics.wildcard;

import java.util.*;

public class WildCardTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        final List<? extends Number> numbers = wildCardTest(list1, list2);
        final List<Integer> integers = genericMethodTest(list1, list2);

        List<Double> list3 = new ArrayList<>();
        List<Double> list4 = new ArrayList<>();
        final List<? extends Number> numbers2 = wildCardTest(list3, list4);
        final List<Double> doubles = genericMethodTest(list3, list4);
    }

    private static List<? extends Number> wildCardTest(List<? extends Number> list, List<? extends Object> list2) {
//        list.add(10);
        list.add(null);

//        Object object = new Object();
//        list.add(object);

//        list.add(list.get(0));
        return list;
    }

    private static <T extends Number> List<T> genericMethodTest(List<T> list, List<T> list2) {
//        list.add(10);
        list.add(null);

//        Object object = new Object();
//        list.add(object);

        list.add(list.get(0));

        return list;
    }
}
