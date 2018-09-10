package javaJungsuk.chap15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx2 {
    public static void main(String[] args) {
        int sum=0;
        int score=0;
        String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\score.dat";
        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);

            while(true){ //while이 true 이더라도 결국 EOFExeption을 발생시키기 떄문에 catch된다.
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        } catch (EOFException e){
            System.out.println("점수의 총 합은 " + sum +"입니다.");
        }catch (IOException ie) {
            System.out.println();
        }finally {
            try {
                if(dis != null){
                    dis.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }//main
}
