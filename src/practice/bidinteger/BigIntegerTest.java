package practice.bidinteger;

import java.math.BigInteger;

public class BigIntegerTest {
    /**
     * 이펙티브자바 108~109쪽에 BigInteger의 negate를 사용하여 복사하면 내부 int 배열은 공유한다고 하는데,,,?
     * @param args
     */
    public static void main(String[] args) {
        final BigInteger bigInteger = BigInteger.valueOf(100);
        final BigInteger negate = bigInteger.negate();
        System.out.println("bigInteger == negate = " + (bigInteger == negate));
        System.out.println("negate.intValue() = " + negate.intValue());
        final BigInteger add = negate.add(BigInteger.TEN);
        System.out.println("(negate == add) = " + (negate == add));
    }
}
