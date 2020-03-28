package practice.equals.autovalue;

import com.google.auto.value.AutoValue;

final class AutoValue_MyClass extends MyClass {

    private final MyClass myFieldClass;

    private final Double doubleRefValue;

    private final Integer integerRefValue;

    private final Double doubleRefNonNullValue;

    private final Integer integerRefNonNullValue;

    private final double doublePrimitiveValue;

    private final int intPrimitiveValue;

    AutoValue_MyClass(
            MyClass myFieldClass,
            Double doubleRefValue,
            Integer integerRefValue,
            Double doubleRefNonNullValue,
            Integer integerRefNonNullValue,
            double doublePrimitiveValue,
            int intPrimitiveValue) {
        if (myFieldClass == null) {
            throw new NullPointerException("Null myFieldClass");
        }
        this.myFieldClass = myFieldClass;
        if (doubleRefValue == null) {
            throw new NullPointerException("Null doubleRefValue");
        }
        this.doubleRefValue = doubleRefValue;
        if (integerRefValue == null) {
            throw new NullPointerException("Null integerRefValue");
        }
        this.integerRefValue = integerRefValue;
        if (doubleRefNonNullValue == null) {
            throw new NullPointerException("Null doubleRefNonNullValue");
        }
        this.doubleRefNonNullValue = doubleRefNonNullValue;
        if (integerRefNonNullValue == null) {
            throw new NullPointerException("Null integerRefNonNullValue");
        }
        this.integerRefNonNullValue = integerRefNonNullValue;
        this.doublePrimitiveValue = doublePrimitiveValue;
        this.intPrimitiveValue = intPrimitiveValue;
    }

    @Override
    MyClass myFieldClass() {
        return myFieldClass;
    }

    @Override
    Double doubleRefValue() {
        return doubleRefValue;
    }

    @Override
    Integer integerRefValue() {
        return integerRefValue;
    }

    @Override
    Double doubleRefNonNullValue() {
        return doubleRefNonNullValue;
    }

    @Override
    Integer integerRefNonNullValue() {
        return integerRefNonNullValue;
    }

    @Override
    double doublePrimitiveValue() {
        return doublePrimitiveValue;
    }

    @Override
    int intPrimitiveValue() {
        return intPrimitiveValue;
    }

    @Override
    public String toString() {
        return "MyClass{"
                + "myFieldClass=" + myFieldClass + ", "
                + "doubleRefValue=" + doubleRefValue + ", "
                + "integerRefValue=" + integerRefValue + ", "
                + "doubleRefNonNullValue=" + doubleRefNonNullValue + ", "
                + "integerRefNonNullValue=" + integerRefNonNullValue + ", "
                + "doublePrimitiveValue=" + doublePrimitiveValue + ", "
                + "intPrimitiveValue=" + intPrimitiveValue
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof MyClass) {
            MyClass that = (MyClass) o;
            return this.myFieldClass.equals(that.myFieldClass())
                    && this.doubleRefValue.equals(that.doubleRefValue())
                    && this.integerRefValue.equals(that.integerRefValue())
                    && this.doubleRefNonNullValue.equals(that.doubleRefNonNullValue())
                    && this.integerRefNonNullValue.equals(that.integerRefNonNullValue())
                    && Double.doubleToLongBits(this.doublePrimitiveValue) == Double.doubleToLongBits(that.doublePrimitiveValue())
                    && this.intPrimitiveValue == that.intPrimitiveValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h$ = 1;
        h$ *= 1000003;
        h$ ^= myFieldClass.hashCode();
        h$ *= 1000003;
        h$ ^= doubleRefValue.hashCode();
        h$ *= 1000003;
        h$ ^= integerRefValue.hashCode();
        h$ *= 1000003;
        h$ ^= doubleRefNonNullValue.hashCode();
        h$ *= 1000003;
        h$ ^= integerRefNonNullValue.hashCode();
        h$ *= 1000003;
        h$ ^= (int) ((Double.doubleToLongBits(doublePrimitiveValue) >>> 32) ^ Double.doubleToLongBits(doublePrimitiveValue));
        h$ *= 1000003;
        h$ ^= intPrimitiveValue;
        return h$;
    }

}
