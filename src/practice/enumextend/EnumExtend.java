package practice.enumextend;

import java.util.Collection;
import java.util.EnumSet;

public class EnumExtend {
    interface Operation {
        double apply(double x, double y);
    }

    enum ExtendedOperation implements Operation {
        EXP("^") {
            @Override
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        },
        REMAINDER("%") {
            @Override
            public double apply(double x, double y) {
                return x % y;
            }
        };

        private final String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }
    }

    public static void main(String[] args) {

    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        EnumSet<T> enumSet = EnumSet.noneOf(opEnumType);
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.println("op.apply(x, y) = " + op.apply(x, y));
        }
    }

    private static void Test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.println("op.apply(x, y) = " + op.apply(x, y));
        }
    }
}
