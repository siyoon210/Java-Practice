package fastcampus3.javaexam.src.main.java.my.examples.javaexam.goods;

public class GoodsExam {
    public static void main(String[] args) {
        Goods g1 = new Goods(1, "java", 1000);
        Goods g2 = new Goods(1, "java", 1000);
        Goods g3 = new Goods(2, "jsp", 5000);

        if (g1.equals(g2)) {
            System.out.println("g1과 g2는 값이 같다");
        }
        if (!g1.equals(g3)) {
            System.out.println("g1과 g2는 값이 같지 않다.");
        }
        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);
    }
}
