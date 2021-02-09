package handle_bufferedreader_without_if_for;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyCode {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.lines()
                .map(String::toUpperCase)
                .filter(s -> s.length() >= 5 && s.length() < 10)
                .forEach(System.out::println);
    }
}
