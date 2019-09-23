package practice.mapremovetest;

import java.util.HashMap;
import java.util.Map;

public class MapRemoveTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);

        map.remove("a");
        map.remove("b");
        map.remove("c");
    }
}
