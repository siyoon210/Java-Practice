package fastcampus.io;

import java.io.*;

//[] 단위로 읽고 쓰기
public class IoExam02 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try{
            File file = new File("./123.txt");

            if(!file.isDirectory() && file.exists()){ //방어적 코딩
                in = new FileInputStream(file);
                out = new FileOutputStream("./123out.txt");

                byte[] buffer =  new byte[1024]; //최대 1024씩 가져와서 출력하겠다.
                int readCount = 0;
                while ((readCount = in.read(buffer))!=-1){
                    out.write(buffer, 0, readCount);
                    System.out.println("readCount = " + readCount);
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
