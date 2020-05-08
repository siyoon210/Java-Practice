package practice.overload;

import java.util.*;

class MyClass {
    String myMethod(Collection<?> collection) {
        return "collection";
    }

    String myMethod(Set<?> set) {
        return "set";
    }

    String myMethod(List<?> list) {
        return "list";
    }
}

public class OverLoadTest {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        Collection<Integer> setAsCollection = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        System.out.println("myClass.myMethod(setAsCollection) = " + myClass.myMethod(setAsCollection));
        System.out.println("myClass.myMethod(set) = " + myClass.myMethod(set));
        System.out.println("myClass.myMethod(list) = " + myClass.myMethod(list));
    }
}
