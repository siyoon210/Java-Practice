package practice.equals.autovalue;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MyClass {
    abstract MyClass myFieldClass();
    abstract Double doubleRefValue();
    abstract Integer integerRefValue();
    abstract Double doubleRefNonNullValue();
    abstract Integer integerRefNonNullValue();
    abstract double doublePrimitiveValue();
    abstract int intPrimitiveValue();

    public static MyClass create(MyClass myFieldClass, Double doubleRefValue, Integer integerRefValue, Double doubleRefNonNullValue, Integer integerRefNonNullValue, double doublePrimitiveValue, int intPrimitiveValue) {
        return new AutoValue_MyClass(myFieldClass, doubleRefValue, integerRefValue, doubleRefNonNullValue, integerRefNonNullValue, doublePrimitiveValue, intPrimitiveValue);
    }
}
