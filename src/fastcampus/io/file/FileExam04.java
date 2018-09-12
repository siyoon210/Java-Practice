package fastcampus.io.file;

import java.io.File;

public class FileExam04 {
    public static void main(String[] args) {
        File file = new File(".\\tmp\\a\\b\\c\\d");

        if(!file.exists()){ //파일이 존재 하지 않는다면.
            file.mkdirs();  //모든 디렉토리르 만든다.
        }
    }
}
