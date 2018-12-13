package fastcampus3.javaexam.src.main.java.my.examples.javaexam.goods;

import java.util.*;

public class GoodsExam2 {
    public static void main(String[] args) {
        Goods g1 = new Goods(1, "java", 1000);
        Goods g2 = new Goods(1, "java", 1000);
        Goods g3 = new Goods(2, "jsp", 5000);
        Goods g4 = new Goods(3, "spring", 500);
        List<Goods> list = new ArrayList<>();

        Goods[] goods = {g1, g2, g3, g4};
        list = Arrays.asList(goods);
        list.stream().map(Goods::toString).forEach(System.out::println);
        Collections.sort(list);
        list.stream().map(Goods::toString).forEach(System.out::println);

        Collections.sort(list, (Comparator.comparing(Goods::getName)));
        list.stream().map(Goods::toString).forEach(System.out::println);
    }
}
