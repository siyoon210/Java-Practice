package fastcampus3.javaexam.src.main.java.my.examples.javaexam.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            list.add(i);
        }

        //Math.random()은 0.0보다 크거나 같고, 1.0보다 작은 임의의 실수를 리턴함
//        for (int i = 0; i < 100; i++) {
//            int idx1 = (int) (Math.random() * 45);
//            int idx2 = (int) (Math.random() * 45);
//
//            if (idx1 != idx2) {
//                Integer tmp = list.get(idx1);
//                list.set(idx1, list.get(idx2));
//                list.set(idx2, tmp);
//            }
//        }
        Collections.shuffle(list);

        for (int i = 0; i < 6; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
