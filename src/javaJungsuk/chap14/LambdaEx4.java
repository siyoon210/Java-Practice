package javaJungsuk.chap14;

import java.util.*;

public class LambdaEx4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //list 모든 요소 출력하기
        //<기존방법>
//        for (Integer i : list) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        //<람다 이용>
        list.forEach(i -> System.out.print(i+","));
        System.out.println();

        //list에서 2또는 3의배수를 제거하기
        //<기존방법> 그냥 내머리속
//        List list2 = new ArrayList();
//        for (Integer i : list) {
//            if (i % 2 == 0 || i % 3 == 0) {
//                list2.add(i);
//            }
//        }
//        list2.forEach(i -> list.remove(i));
//        System.out.println(list);

        //<람다 이용>
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        //각 요소에 10 곱하기.
        //<기존방법>
//        for (int i = 0; i<list.size(); i++) {
//            list.set(i, list.get(i) * 10);
//        }
//        System.out.println(list);

        //<람다이용>
        list.replaceAll(i -> i * 10);
        System.out.println(list);

        //내인생에서 앞으로 컬렉션 다룰때 포이치는 안쓰도록한다!!

        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

        //맵의 모든 요소를 출력하기
        //<기존방법>
//        for (int i = 0; i < map.size(); i++) {
//            System.out.println();
//        }

        //<람다 이용>
        map.forEach((k,v)-> System.out.println(k+"의 요소는 : " +v));
    }
}
