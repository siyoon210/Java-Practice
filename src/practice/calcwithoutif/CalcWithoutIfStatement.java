package practice.calcwithoutif;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class Calculator {
    enum Operator {
        PLUS("+", (num1, num2) -> num1 + num2),
        MINUS("-", (num1, num2) -> num1 - num2),
        MULTIPLY("*", (num1, num2) -> num1 * num2),
        DIVIDE("/", (num1, num2) -> num1 / num2);

        private String strOperator;
        private BiFunction<Integer, Integer, Integer> expression;

        Operator(String strOperator, BiFunction<Integer, Integer, Integer> expression) {
            this.strOperator = strOperator;
            this.expression = expression;
        }

        public int calc(int num1, int num2) {
            return this.expression.apply(num1, num2);
        }
    }

    private Map<String, Operator> stringOperatorMap;

    Calculator() {
        initMap();
    }

    private void initMap() {
        this.stringOperatorMap = new HashMap<>();
        for (Operator value : Operator.values()) {
            stringOperatorMap.put(value.strOperator, value);
        }
    }

    public double calc(String operator, int num1, int num2) {
        return stringOperatorMap.get(operator).expression.apply(num1, num2);
    }
}

public class CalcWithoutIfStatement {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("calculator.calc(\"+\", 10, 2) = " + calculator.calc("+", 10, 2));
        System.out.println("calculator.calc(\"-\", 10, 2) = " + calculator.calc("-", 10, 2));
        System.out.println("calculator.calc(\"*\", 10, 2) = " + calculator.calc("*", 10, 2));
        System.out.println("calculator.calc(\"/\", 10, 2) = " + calculator.calc("/", 10, 2));
    }
}
