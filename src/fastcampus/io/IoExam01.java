package fastcampus.io;

import java.io.*;

//1바이트씩 읽고 쓰기
public class IoExam01 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try{
            File file = new File("./123.txt");

            if(!file.isDirectory() && file.exists()){ //방어적 코딩
                in = new FileInputStream(file);
                out = new FileOutputStream("./123out.txt");
                int readData = 0;
                while ((readData = in.read())!=-1){
                    out.write(readData);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                in.close();
            }catch (IOException ie){}
            try{
                out.close();
            }catch (IOException ie){}
        }
    }
}
