package practice.equals.intellijdefault;

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

        if (Double.compare(myClass1.doublePrimitiveValue, doublePrimitiveValue) != 0) return false;
        if (intPrimitiveValue != myClass1.intPrimitiveValue) return false;
        if (myClass != null ? !myClass.equals(myClass1.myClass) : myClass1.myClass != null) return false;
        if (doubleRefValue != null ? !doubleRefValue.equals(myClass1.doubleRefValue) : myClass1.doubleRefValue != null)
            return false;
        if (integerRefValue != null ? !integerRefValue.equals(myClass1.integerRefValue) : myClass1.integerRefValue != null)
            return false;
        if (!doubleRefNonNullValue.equals(myClass1.doubleRefNonNullValue)) return false;
        return integerRefNonNullValue.equals(myClass1.integerRefNonNullValue);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = myClass != null ? myClass.hashCode() : 0;
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
