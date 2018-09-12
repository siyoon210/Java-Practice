package fastcampus.io;

import java.io.*;

//키보드로부터 한줄씩 입력받아 파일에 한줄씩 출력하시오.
//quit이라고 입력하면 프로그램은 종료됩니다.
//1. 어디서 읽어들이지? 키보드 Systme.in 표준입력 InputStream
//2. 어디다 쓰지? 파일 FileWriter
//3. 읽는 방법 : 한줄씩 - BufferedReader
//4. 쓰는 방법 : 한졸씩 - PrintWriter

public class IoExam05 {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        String fileName = "."+File.separator+"tmp"+File.separator+"readLine.txt";

        try {
            br= new BufferedReader(new InputStreamReader(System.in));
            pw= new PrintWriter(new FileWriter(fileName));
            String line = null;

            while ((line=br.readLine())!=null){
                if(line.equals("quit")){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }

    }
}
