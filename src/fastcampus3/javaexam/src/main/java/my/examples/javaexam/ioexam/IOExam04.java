package my.examples.javaexam.ioexam;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExam04 {
    public static void main(String[] args) {
        byte[] bytes = new byte[20];
        for (byte i = 0; i < 20; i++) {
            bytes[i] = (byte) (i + 1);
        }

        ByteArrayInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new ByteArrayInputStream(bytes);
            out = new FileOutputStream("bytearray.dat");
            int readData = 0;
            while ((readData = in.read()) != -1) { //
                out.write(readData); //정수단위라도 가장 끝에 한바이트만 쓴다.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
