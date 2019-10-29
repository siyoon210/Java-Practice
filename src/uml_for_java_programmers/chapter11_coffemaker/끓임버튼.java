package uml_for_java_programmers.chapter11_coffemaker;

public class 끓임버튼 {
    private final CoffeeMaker coffeeMaker;

    public 끓임버튼(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    void on() {
        coffeeMaker.끓임버튼ON();
    }
}
