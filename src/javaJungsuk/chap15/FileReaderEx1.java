package javaJungsuk.chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\siyoon\\Documents\\GitHub\\Java-Practice\\src\\javaJungsuk\\chap15\\test.txt";

        try {
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);
            int data=0;
            while((data = fis.read())!=-1){
               // System.out.println(data);
                System.out.print((char)data); //문자로 형변환 해주어야 한다.
            }
            System.out.println();
            fis.close();

            while ((data=fr.read())!=-1) {
             //   System.out.println(data);
                System.out.print((char)data); //문자로 형변환 해주어야 한다.
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
