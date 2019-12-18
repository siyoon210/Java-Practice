package practice.mapcomputeifabsent;

import java.util.HashMap;
import java.util.Map;

public class MapComputeIfAbsentTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

//        map.put("siyoon", 1);

        final Integer siyoon = map.computeIfAbsent("siyoon", s -> s.length());
        System.out.println("siyoon = " + siyoon); // computeIfAbsent는 값이 바로 할당되네

        final Integer puru = map.putIfAbsent("puru", getLength("puru"));
        System.out.println("puru = " + puru); // putIfAbsent는 바로 할당이 안돼
        System.out.println("map.get(\"puru\") = " + map.get("puru")); // 근데 get으로 받으면 있긴
        final Integer puru2 = map.putIfAbsent("puru", getLength("puru"));
        System.out.println("puru2 = " + puru2);
        System.out.println("map.get(\"puru\") = " + map.get("puru"));
        final Integer puru3 = map.putIfAbsent("puru", 777);
        System.out.println("puru3 = " + puru3);
        System.out.println("map.get(\"puru\") = " + map.get("puru"));
    }

    private static int getLength(String str) {
        return str.length();
    }
}
