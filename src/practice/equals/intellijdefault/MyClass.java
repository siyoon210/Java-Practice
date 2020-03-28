package practice.equals.intellijdefault;

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

        if (Double.compare(myClass.doublePrimitiveValue, doublePrimitiveValue) != 0) return false;
        if (intPrimitiveValue != myClass.intPrimitiveValue) return false;
        if (myFieldClass != null ? !myFieldClass.equals(myClass.myFieldClass) : myClass.myFieldClass != null)
            return false;
        if (doubleRefValue != null ? !doubleRefValue.equals(myClass.doubleRefValue) : myClass.doubleRefValue != null)
            return false;
        if (integerRefValue != null ? !integerRefValue.equals(myClass.integerRefValue) : myClass.integerRefValue != null)
            return false;
        if (!doubleRefNonNullValue.equals(myClass.doubleRefNonNullValue)) return false;
        return integerRefNonNullValue.equals(myClass.integerRefNonNullValue);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = myFieldClass != null ? myFieldClass.hashCode() : 0;
        result = 31 * result + (doubleRefValue != null ? doubleRefValue.hashCode() : 0);
        result = 31 * result + (integerRefValue != null ? integerRefValue.hashCode() : 0);
        result = 31 * result + doubleRefNonNullValue.hashCode();
        result = 31 * result + integerRefNonNullValue.hashCode();
        temp = Double.doubleToLongBits(doublePrimitiveValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + intPrimitiveValue;
        return result;
    }
}
