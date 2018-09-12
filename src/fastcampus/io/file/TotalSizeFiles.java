package fastcampus.io.file;

import java.io.File;
import java.util.List;

public class TotalSizeFiles {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println("현재 절대 경로 : "+file.getAbsolutePath());
        int sum = 0;

        System.out.println("현재 경로의 총 용량 : "+ getTotalSize(sum, file) + " byte");
    }

    static int getTotalSize(int sum, File file){
        File[] fileList= file.listFiles();
        for(File f : fileList){
            if(f.isDirectory()){
                int tsum=0;
                sum+=getTotalSize(tsum, f); //재귀함수 호출
            }
            else if(f.isFile()){
                System.out.println(f.getName() +" : "+f.length());
                sum += f.length();
            }
        }
        return sum;
    }
}
