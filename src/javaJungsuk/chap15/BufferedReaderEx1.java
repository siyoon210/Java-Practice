package javaJungsuk.chap15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx1 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\BufferedReaderEx1.java";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            for(int i=1; (line=br.readLine())!=null; i++){ //for문의 i는 라인수를 출력하기 위함, while문 써도 됨
                if(line.indexOf(";")!=-1){
                    System.out.println(i+":"+line);
                }
            }
//            int i = 1;
//            while ((line = br.readLine())!=null){
//                if(line.indexOf(";")!=-1){
//                    System.out.println(i+":"+line);
//                }
//                i++;
//            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//메인

}
