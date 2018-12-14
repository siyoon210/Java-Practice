package fastcampus3.javaexam.src.main.java.my.examples.javaexam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionTest01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("hello");
        set.add("world");
        set.add("!!!");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        set.forEach(i-> System.out.println(i));
    }
}
