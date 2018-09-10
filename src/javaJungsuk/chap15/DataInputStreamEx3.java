package javaJungsuk.chap15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx3 {
    public static void main(String[] args) {
        int sum =0;
        int score = 0;
        String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\score.dat";

        //try-with-resources문을 이용하여 finally의 close()를 생략가능
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            while(true){
                score = dis.readInt();
                System.out.println(score);
                sum+=score;
            }
        }catch (EOFException e){
            System.out.println("점수의 총합은 : "+sum);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }//메인
}
