package practice.mylist;

import java.util.AbstractList;
import java.util.List;

public interface MyListInterface {
    static List<Integer> intArrayAsList(int[] a) {

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}

class Test{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> list = MyListInterface.intArrayAsList(arr);
        System.out.println("list.get(0) = " + list.get(0));
    }
}