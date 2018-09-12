package fastcampus.io;

import java.io.*;

//[] 단위로 읽고 쓰기
public class IoExam02 {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("."+File.separator+"tmp"+ File.separator+"123.txt");
            OutputStream out = new FileOutputStream("."+File.separator+"tmp"+ File.separator+"123copy.txt");

            byte[] buffer = new byte[16];
            int readCount=0;
            while ((readCount=in.read(buffer))!=-1){
                out.write(buffer,0,readCount);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//메인
}
