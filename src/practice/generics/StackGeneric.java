package practice.generics;

import java.util.Set;

class Stack<E> {
    int a;
    E[] elements;

    @SuppressWarnings("unchecked")
    Stack() {
        elements = (E[]) new Object[10];
    }

    <T> void method(Set<T> t) {
        int a;
    }
}

public class StackGeneric {
    public static void main(String[] args) {

        final Stack<Integer> integerStack = new Stack<>();
    }
}
