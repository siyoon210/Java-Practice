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

    default List<Integer> intArrayAsListByDefaultMethod(int[] a) {
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

class MyListInterfaceImpl implements MyListInterface {

}

class Test{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> list = MyListInterface.intArrayAsList(arr);
        System.out.println("list.get(0) = " + list.get(0));
        list.set(0, 1000);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("arr[0] = " + arr[0]);

        MyListInterface myListInterface = new MyListInterfaceImpl();
        List<Integer> list1 = myListInterface.intArrayAsListByDefaultMethod(arr);
        System.out.println("list1.get(0) = " + list1.get(0));
        list1.set(0, 3000);
        System.out.println("list1.get(0) = " + list1.get(0));
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("arr[0] = " + arr[0]);
    }
}