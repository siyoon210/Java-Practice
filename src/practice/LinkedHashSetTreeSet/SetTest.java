package practice.LinkedHashSetTreeSet;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(5);
        linkedHashSet.add(4);
        linkedHashSet.add(3);
        linkedHashSet.add(2);
        linkedHashSet.add(1);

        System.out.println("linkedHashSet");
        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(4);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);

        System.out.println("treeSet");
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}
