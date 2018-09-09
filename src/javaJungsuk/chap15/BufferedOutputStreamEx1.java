package javaJungsuk.chap15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\123.txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            for(int i='1'; i<='9'; i++){
                bos.write(i);
            }
            //fos.close();
            bos.close(); //bos에서 close해야 남은 버퍼의 내용이 flush 되면서 모든 출력이 시행된다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
