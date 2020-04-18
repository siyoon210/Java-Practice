package practice.generics;

import java.util.HashSet;
import java.util.Set;

public class WildcardReturn {
    public static void main(String[] args) {
        final Set<Integer> integers1 = new HashSet<>();
        final Set<Double> integers2 = new HashSet<>();

        final Set<? extends Integer> integers = myMethod(integers1, integers2);
    }

    private static <E> Set<E> myMethod(Set<E> set1, Set<E> set2) {
        @SuppressWarnings("unchecked")
        E e = (E) new Object();
        set1.add(e);
        set1.add(null);

        return null;
    }

    private static Set<?> myMethod(Set<?> set1, Set<?> set2) {
        //
        set1.add();
        set1.add(null);

        return null;
    }

    private void myMethod3(Set<? extends Number> t1, Set<? extends Number> t2, Set<? extends Number> t3) {

    }

    private <T extends Number> void myMethod4(Set<T> t1, Set<T> t2, Set<T> t3) {

    }
}
