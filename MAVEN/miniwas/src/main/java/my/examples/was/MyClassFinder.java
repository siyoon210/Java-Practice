package my.examples.was;

import java.io.File;

public class MyClassFinder {
    public static void main(String[] args) {
        findClass();
    }

    public static void findClass(){
        String path = Object.class.getClass().getResource("/").getPath(); //현재의 루트 디렉토리

        File file = new File(path);
        File[] files = file.listFiles();

        scanDirectory(files);

    }

    public static void scanDirectory(File[] files){
        for(File f : files){
            if(f.isDirectory()){
                scanDirectory(f.listFiles());
            }
            else{
                System.out.println(f);
            }
        }
    }
}
