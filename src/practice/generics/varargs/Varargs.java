package practice.generics.varargs;

import java.util.List;

public class Varargs {
    public static void main(String[] args) {
        varargsMethodWithGenericType();
    }
    @SafeVarargs
    public static final void varargsMethodWithGenericType(List<String>... strs) {
        System.out.println("strs.getClass() = " + strs.getClass().getTypeName());
        System.out.println("strs.getClass() = " + strs.getClass().getName());
    }
}
