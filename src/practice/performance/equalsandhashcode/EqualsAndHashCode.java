package practice.performance.equalsandhashcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyClass{
    int index;

    public MyClass(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        return index == myClass.index;
    }

    @Override
    public int hashCode() {
        return index;
    }
}

public class EqualsAndHashCode {
    public static void main(String[] args) {
        List<MyClass> myClasses = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            myClasses.add(new MyClass(i));
        }

        Double[] results = new Double[1000];
        for (int count = 0; count < 1000; count++) {
            long startTime = System.nanoTime();
            for (int i = 0; i < 1000000; i+=1000) {
                myClasses.get(i).getIndex();
            }
            long endTime = System.nanoTime();

            Double elapsedTime = (endTime -startTime) / 1000000.0;
            results[count] = elapsedTime;
        }

        Double sum = 0.0;
        for (int i = 2; i < results.length; i++) {
            sum += results[i];
        }
        System.out.println(sum / results.length);
    }
}
