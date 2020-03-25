package practice.equals;

class MyClass {
    Float myValue1;
    Integer myValue2;
    float myValue3;
    int myValue4;
    double myValue5;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyClass)) return false;

        MyClass myClass = (MyClass) o;

        if (Float.compare(myClass.myValue3, myValue3) != 0) return false;
        if (myValue4 != myClass.myValue4) return false;
        if (Double.compare(myClass.myValue5, myValue5) != 0) return false;
        if (!myValue1.equals(myClass.myValue1)) return false;
        return myValue2 != null ? myValue2.equals(myClass.myValue2) : myClass.myValue2 == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = myValue1.hashCode();
        result = 31 * result + (myValue2 != null ? myValue2.hashCode() : 0);
        result = 31 * result + (myValue3 != +0.0f ? Float.floatToIntBits(myValue3) : 0);
        result = 31 * result + myValue4;
        temp = Double.doubleToLongBits(myValue5);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
public class EqualsTest {

}
