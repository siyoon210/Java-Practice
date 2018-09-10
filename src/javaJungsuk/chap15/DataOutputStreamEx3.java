package javaJungsuk.chap15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx3 {
    public static void main(String[] args) {
        try {
            int[] score = {100, 90, 95, 85, 50};
            String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\score.dat";


            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            for (int i=0; i<score.length; i++){
                dos.writeInt(score[i]);
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
