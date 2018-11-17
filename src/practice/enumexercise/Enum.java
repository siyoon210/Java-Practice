package practice.enumexercise;

public class Enum {
    enum Fruit {APPLE, BANANA, PEACH}
    enum Company{APPLE, GOOGLE, SAMSUMG}

    public static void main(String[] args) {
        System.out.println(Fruit.APPLE);
        System.out.println(Company.APPLE);

//        if (Fruit.APPLE != Company.APPLE) {
//
//        }

        Fruit Type = Fruit.APPLE;
        switch (Type) {
            case APPLE:
                System.out.println("애플");
                break;
            case PEACH:
                System.out.println("복숭아");
                break;
            case BANANA:
                System.out.println("바나나");
                break;
        }
    }
}
