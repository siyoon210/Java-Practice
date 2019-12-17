package practice.mapcomputeifabsent;

import java.util.HashMap;
import java.util.Map;

public class MapComputeIfAbsentTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("siyoon", 1);

        final Integer siyoon = map.computeIfAbsent("siyoon", s -> s.length());
        System.out.println("siyoon = " + siyoon);

        final Integer puru = map.putIfAbsent("puru", 777);
        System.out.println("puru = " + puru);
        System.out.println("map.get(\"puru\") = " + map.get("puru"));
    }
}
