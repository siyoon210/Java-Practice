package practice.polymorphism.calc;

public class CalculatorMain {
    public static void main(String[] args) {
        Node val1 = new ValueNode(1);
        Node val2 = new ValueNode(2);
        Node val3 = new ValueNode(3);
        Node multiOp = new MultipleNode(val2, val3);
        Node addOp = new AdditionalNode(val1, multiOp);

        System.out.println("addOp.evaluate() = " + addOp.evaluate());
    }
}
