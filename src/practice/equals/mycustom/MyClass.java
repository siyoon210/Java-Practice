package practice.equals.mycustom;

import java.util.Objects;

public class MyClass {
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

        return intPrimitiveValue == myClass.intPrimitiveValue &&
                Double.compare(myClass.doublePrimitiveValue, doublePrimitiveValue) == 0 &&
                integerRefNonNullValue.equals(myClass.integerRefNonNullValue) &&
                doubleRefNonNullValue.equals(myClass.doubleRefNonNullValue) &&
                Objects.equals(integerRefValue, myClass.integerRefValue) &&
                Objects.equals(doubleRefValue, myClass.doubleRefValue) &&
                Objects.equals(myFieldClass, myClass.myFieldClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myFieldClass, doubleRefValue, integerRefValue, doubleRefNonNullValue, integerRefNonNullValue, doublePrimitiveValue, intPrimitiveValue);
    }

    public MyClass(MyClass myFieldClass, Double doubleRefValue, Integer integerRefValue, Double doubleRefNonNullValue, Integer integerRefNonNullValue, double doublePrimitiveValue, int intPrimitiveValue) {
        this.myFieldClass = myFieldClass;
        this.doubleRefValue = doubleRefValue;
        this.integerRefValue = integerRefValue;
        this.doubleRefNonNullValue = doubleRefNonNullValue;
        this.integerRefNonNullValue = integerRefNonNullValue;
        this.doublePrimitiveValue = doublePrimitiveValue;
        this.intPrimitiveValue = intPrimitiveValue;
    }
}
