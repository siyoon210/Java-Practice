package iteratorremove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IteratorRemoveTest {
    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        final Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }

        assertEquals(list.size(), 3);
    }
}
