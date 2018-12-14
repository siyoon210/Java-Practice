package my.examples.javaexam.folderfile;

import java.util.List;

public class FileExam {
    public static void main(String[] args) {
        File file = new File();
        List<String> list2 = file.getList();
        list2.add("가나다");
        list2.add("abc");
        list2.add("def");

        System.out.println(file.getList().size());
    }
}
