package my.examples.ioexam;

import java.io.File;
import java.util.Properties;

public class IOExam01 {
    public static void main(String[] args) {
        // /home/siyoon/Documents/Java-Practice/src/fastcampus3/fileio
        String fileName = "/home/siyoon/Documents/Java-Practice/src/fastcampus3/fileio";
        File file = new File(fileName);

        // 1. 위의 폴더가 있는지 없는지 검사한다. 있으면 있다. 없으면 없다라고 출력
        if (file.exists()) {
            System.out.println("있다");
        } else {
            System.out.println("없다");
        }

        // 2. 해당 경로가 파일이지, 폴더인지 검사한다. 파일이면 파일, 폴더면 폴더로 출력
        if (file.isDirectory()) {
            System.out.println("폴더");
        } else {
            System.out.println("파일");
        }

        // 3+4. 해당 경로에 어떤 파일과 폴더들이 있는지 정보를 출력한다.
        if (file.exists()) {
            if (file.isDirectory()) {
                printDir("", file);
            } else {
                printFile("", file);
            }
        }
    }

    public static void printFile(String space, File file) {
        System.out.println(space+file.getName());
    }

    public static void printDir(String space, File file) {
        System.out.println(space+"[DIR]"+file.getName());
        space +="\t";
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                printDir(space, f);
            } else {
                printFile(space, f);
            }
        }
    }

}
