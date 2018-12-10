package fastcampus3.javaexam.src.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionTest03 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("001", "둘리");
        map.put("002", "도우너");
        map.put("003", "또치");

        System.out.println(map.get("002"));
        System.out.println(map.get("004"));

        //Q)모든 키들을 출력하시오.

        //A)
        while (map.keySet().iterator().hasNext()) {
            String str = map.keySet().iterator().next();
            System.out.println(str);
        }
    }
}
