package javaJungsuk.chap14;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        //길이가 5인 File 배열 만들기
        File[] fileArr = {
                new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex1.txt"),
        };

        //Stream으로 변환하기
        Stream<File> fileStream = Stream.of(fileArr);

        //Stream<File>을 Stream<String>으로 변환하기
        Stream<String> filnenameStream = fileStream.map(File::getName);

        //모든 파일이름 출력
        filnenameStream.forEach(System.out::println);

        //파일스트림 재생성 (이미 쓴건 못쓴다.)
        fileStream = Arrays.stream(fileArr);

        //파일 스트림으로
        //1. String으로 바꾸고 2. 확장자가 없는 것을 제외하고 3. 확장자만 추출하고 4. 모두 대문자로 변환 5. 중복제거 6. 출
        fileStream.map(File::getName)
                .filter(s -> s.contains("."))
                .map(s -> s.substring(s.indexOf(".") + 1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::print);
    }
}
