package fastcampus3.javaexam.src.main.java.my.examples.javaexam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.forEach(i-> System.out.println(i));
    }
}
