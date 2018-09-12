package fastcampus.io.file;

import java.io.File;

public class FileExam03 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles(); //해당 파일의 경로의 모든 파일들의 리스트를 반환함

        for(File f : files){
            if(f.isDirectory()){
                System.out.println("[DIR] : "+ f.getAbsolutePath());
            }
            else {
                System.out.println("[File] : "+ f.getAbsolutePath());
            }
        }
    }
}
