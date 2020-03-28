package practice.equals.java7;

import java.util.Objects;

class MyClass {
    MyClass myClass;
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
        MyClass myClass1 = (MyClass) o;
        return Double.compare(myClass1.doublePrimitiveValue, doublePrimitiveValue) == 0 &&
                intPrimitiveValue == myClass1.intPrimitiveValue &&
                Objects.equals(myClass, myClass1.myClass) &&
                Objects.equals(doubleRefValue, myClass1.doubleRefValue) &&
                Objects.equals(integerRefValue, myClass1.integerRefValue) &&
                doubleRefNonNullValue.equals(myClass1.doubleRefNonNullValue) &&
                integerRefNonNullValue.equals(myClass1.integerRefNonNullValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myClass, doubleRefValue, integerRefValue, doubleRefNonNullValue, integerRefNonNullValue, doublePrimitiveValue, intPrimitiveValue);
    }
}
