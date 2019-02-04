package fastcampus.io.file;

import java.io.File;

public class FileExam01 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\fastcampus\\io\\file\\Readme.txt";
        //string fileName2 = ".\\Welcome.HTML";
        File file = new File(fileName);

        if(file.exists()){
            System.out.println(fileName + "있어요");
            System.out.println(file.getPath());
        }
        else
            System.out.println("없어요");
    }
}
