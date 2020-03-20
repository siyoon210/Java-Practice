package effective_java.item2_pizza_exam.constructor;

import java.util.EnumSet;
import java.util.Set;

abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    public Pizza(Set<Topping> toppings) {
        this.toppings = toppings;
    }
}

class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public NyPizza(Set<Topping> toppings, Size size) {
        super(toppings);
        this.size = size;
    }
}

class Calzone extends Pizza {
    private final boolean sauceInside;

    public Calzone(Set<Topping> toppings, boolean sauceInside) {
        super(toppings);
        this.sauceInside = sauceInside;
    }
}

public class ConstructorExam {
    public static void main(String[] args) {
        //뉴욕피자 만들기
        Set<Pizza.Topping> nyPizzaToppings = EnumSet.of(Pizza.Topping.SAUSAGE, Pizza.Topping.ONION);
        NyPizza nyPizza = new NyPizza(nyPizzaToppings, NyPizza.Size.SMALL);

        //칼초네피자 만들기
        Set<Pizza.Topping> calzoneToppings = EnumSet.of(Pizza.Topping.HAM);
        Calzone calzone = new Calzone(calzoneToppings, true);
    }
}


