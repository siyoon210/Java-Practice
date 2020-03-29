package practice.equals.lombok;

public class MyClass {
    MyClass myFieldClass;
    Double doubleRefValue;
    Integer integerRefValue;
    Double doubleRefNonNullValue;
    Integer integerRefNonNullValue;
    double doublePrimitiveValue;
    int intPrimitiveValue;

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MyClass)) return false;
        final MyClass other = (MyClass) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$myFieldClass = this.myFieldClass;
        final Object other$myFieldClass = other.myFieldClass;
        if (this$myFieldClass == null ? other$myFieldClass != null : !this$myFieldClass.equals(other$myFieldClass))
            return false;
        final Object this$doubleRefValue = this.doubleRefValue;
        final Object other$doubleRefValue = other.doubleRefValue;
        if (this$doubleRefValue == null ? other$doubleRefValue != null : !this$doubleRefValue.equals(other$doubleRefValue))
            return false;
        final Object this$integerRefValue = this.integerRefValue;
        final Object other$integerRefValue = other.integerRefValue;
        if (this$integerRefValue == null ? other$integerRefValue != null : !this$integerRefValue.equals(other$integerRefValue))
            return false;
        final Object this$doubleRefNonNullValue = this.doubleRefNonNullValue;
        final Object other$doubleRefNonNullValue = other.doubleRefNonNullValue;
        if (this$doubleRefNonNullValue == null ? other$doubleRefNonNullValue != null : !this$doubleRefNonNullValue.equals(other$doubleRefNonNullValue))
            return false;
        final Object this$integerRefNonNullValue = this.integerRefNonNullValue;
        final Object other$integerRefNonNullValue = other.integerRefNonNullValue;
        if (this$integerRefNonNullValue == null ? other$integerRefNonNullValue != null : !this$integerRefNonNullValue.equals(other$integerRefNonNullValue))
            return false;
        if (Double.compare(this.doublePrimitiveValue, other.doublePrimitiveValue) != 0) return false;
        if (this.intPrimitiveValue != other.intPrimitiveValue) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MyClass;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $myFieldClass = this.myFieldClass;
        result = result * PRIME + ($myFieldClass == null ? 43 : $myFieldClass.hashCode());
        final Object $doubleRefValue = this.doubleRefValue;
        result = result * PRIME + ($doubleRefValue == null ? 43 : $doubleRefValue.hashCode());
        final Object $integerRefValue = this.integerRefValue;
        result = result * PRIME + ($integerRefValue == null ? 43 : $integerRefValue.hashCode());
        final Object $doubleRefNonNullValue = this.doubleRefNonNullValue;
        result = result * PRIME + ($doubleRefNonNullValue == null ? 43 : $doubleRefNonNullValue.hashCode());
        final Object $integerRefNonNullValue = this.integerRefNonNullValue;
        result = result * PRIME + ($integerRefNonNullValue == null ? 43 : $integerRefNonNullValue.hashCode());
        final long $doublePrimitiveValue = Double.doubleToLongBits(this.doublePrimitiveValue);
        result = result * PRIME + (int) ($doublePrimitiveValue >>> 32 ^ $doublePrimitiveValue);
        result = result * PRIME + this.intPrimitiveValue;
        return result;
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
