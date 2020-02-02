package practice.polymorphism.calc;

public class NodeAntiVer {
    char operator;
    double value;
    Node left;
    Node right;
    double evaluate() {
        switch (operator) {
            case '#':
                return value;
            case '+':
                return left.evaluate() + right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            // case ...
        }
    }
}
