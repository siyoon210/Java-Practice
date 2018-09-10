package javaJungsuk.chap15;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx1 {
    public static void main(String[] args) {
        FileOutputStream fos =null;
        DataOutputStream dos =null;
        String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\sample.dat";
        try {
            fos = new FileOutputStream(fileName);
            dos = new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeFloat(20.f);
            dos.writeBoolean(true);

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
