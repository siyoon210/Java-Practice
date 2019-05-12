package practice.calcwithoutif;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class Calculator {
    private static Map<String, BiFunction<Double, Double, Double>> stringOperatorMap;

    static {
        stringOperatorMap = new HashMap<>();
        stringOperatorMap.put("+", (num1, num2) -> num1 + num2);
        stringOperatorMap.put("-", (num1, num2) -> num1 - num2);
        stringOperatorMap.put("*", (num1, num2) -> num1 * num2);
        stringOperatorMap.put("/", (num1, num2) -> num1 / num2);
    }

    public static double calc(String operator, double num1, double num2) {
        return stringOperatorMap.get(operator).apply(num1, num2);
    }
}

public class CalcWithoutIfStatement {
    public static void main(String[] args) {
        System.out.println("calculator.calc(\"+\", 10, 2) = " + Calculator.calc("+", 10, 2));
        System.out.println("calculator.calc(\"-\", 10, 2) = " + Calculator.calc("-", 10, 2));
        System.out.println("calculator.calc(\"*\", 10, 2) = " + Calculator.calc("*", 10, 2));
        System.out.println("calculator.calc(\"/\", 11, 2) = " + Calculator.calc("/", 11, 2));
    }
}
