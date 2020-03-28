package practice.equals.java7;

import java.util.Objects;

class MyClass {
    MyClass myFieldClass;
    Double doubleRefValue;
    Integer integerRefValue;
    Double doubleRefNonNullValue;
    Integer integerRefNonNullValue;
    double doublePrimitiveValue;
    int intPrimitiveValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyClass)) return false;
        MyClass myClass = (MyClass) o;
        return Double.compare(myClass.doublePrimitiveValue, doublePrimitiveValue) == 0 &&
                intPrimitiveValue == myClass.intPrimitiveValue &&
                Objects.equals(myFieldClass, myClass.myFieldClass) &&
                Objects.equals(doubleRefValue, myClass.doubleRefValue) &&
                Objects.equals(integerRefValue, myClass.integerRefValue) &&
                doubleRefNonNullValue.equals(myClass.doubleRefNonNullValue) &&
                integerRefNonNullValue.equals(myClass.integerRefNonNullValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myFieldClass, doubleRefValue, integerRefValue, doubleRefNonNullValue, integerRefNonNullValue, doublePrimitiveValue, intPrimitiveValue);
    }
}
