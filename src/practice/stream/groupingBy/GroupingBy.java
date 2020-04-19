package practice.stream.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupingBy {
    static class MyObject {
        int index;
        String name;

        public MyObject(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        MyObject m1 = new MyObject(1, "A");
        MyObject m2 = new MyObject(1, "B");
        MyObject m3 = new MyObject(2, "C");
        MyObject m4 = new MyObject(2, "D");
        MyObject m5 = new MyObject(1, "E");
        MyObject m6 = new MyObject(3, "F");

        final List<MyObject> myObjects = Arrays.asList(m1, m2, m3, m4, m5, m6);

        final Map<Integer, List<MyObject>> collect = myObjects.stream().collect(Collectors.groupingBy(m -> m.index));

        assertThat(collect.size()).isEqualTo(3);
        assertThat(collect.get(1).size()).isEqualTo(3);
        assertThat(collect.get(1).contains(m5)).isEqualTo(true);
        assertThat(collect.get(2).size()).isEqualTo(2);
        assertThat(collect.get(2).contains(m3)).isEqualTo(true);
        assertThat(collect.get(3).size()).isEqualTo(1);
        assertThat(collect.get(3).contains(m6)).isEqualTo(true);
    }
}
