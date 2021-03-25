package practice.enumexercise;

public class Enum {
    private static Type getTypeObject(Fruit Type) {
        switch (Type) {
            case APPLE:
                return new Apple();
            case PEACH:
                return new Peach();
            case BANANA:
                return new Banana();
        }
        return null;
    }

    enum Fruit {APPLE, BANANA, PEACH}
    enum Company{APPLE, GOOGLE, SAMSUMG}

    public static void main(String[] args) {
        System.out.println(Fruit.APPLE);
        System.out.println(Company.APPLE);

        Fruit Type = Fruit.APPLE;
        getTypeObject(Type).main();
    }
}
