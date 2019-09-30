package practice.mapcomputeifabsent;

import java.util.HashMap;
import java.util.Map;

public class MapComputeIfAbsentTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("siyoon", 1);
        final Integer integer = map.computeIfAbsent("siyoon", String::hashCode);
        System.out.println("integer = " + integer);


    }
}
