package practice.polymorphism.calc;

abstract class Node {
    abstract double evaluate();
}

class ValueNode extends Node {
    public ValueNode(double value) {
        this.value = value;
    }

    private double value;

    @Override
    double evaluate() {
        return value;
    }
}

abstract class OpNode extends Node {
    public OpNode() {
    }

    public OpNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    Node left;
    Node right;
}

class AdditionalNode extends OpNode {
    public AdditionalNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class MultipleNode extends OpNode {
    public MultipleNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
