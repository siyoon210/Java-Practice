package fastcampus.io;


import java.io.*;

//1바이트씩 읽고 쓰기
public class IoExam01 {
    public static void main(String[] args) {

        try {
            InputStream in = new FileInputStream("."+File.separator+"tmp"+ File.separator+"123.txt");
            OutputStream out = new FileOutputStream("."+File.separator+"tmp"+ File.separator+"123copy.txt");

            int data=0;
            while((data=in.read())!=-1){
                out.write(data);
            }

            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }//메인
}
