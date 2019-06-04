package practice.mapmerge;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapMerge {
    public static void main(String[] args) {
        String[] strs = {"A", "B", "C", "A", "A", "B"};

        Map<String, Integer> stringCountMap = new HashMap<>();

        //첫번째 방법 포문
        for (final String aChar : strs) {
            stringCountMap.merge(aChar, 1, Integer::sum);
        }

        //두번째 방법 스트림
        Arrays.stream(strs).forEach(str -> stringCountMap.merge(str, 1, Integer::sum));


        //출력 1 포문으로 출력하기
        for (final String character : stringCountMap.keySet()) {
            System.out.println(character + " : " + stringCountMap.get(character));
        }

        //출력 2 스트림으로 출력하기
        stringCountMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
