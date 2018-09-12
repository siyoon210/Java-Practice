package javaJungsuk.chap15.exercise15_1;

import java.io.*;

public class FileHead {
    public static void main(String[] args) {
        try {
            String fileName = "."+ File.separator+"src"+File.separator+"javaJungsuk"+File.separator+"chap15"+File.separator+"exercise15_1"+File.separator+args[0];
            File file = new File(fileName);
            if(!file.exists()){
                System.out.println("파일이 없습니다.");
            }
            else if (!file.isDirectory()&&file.exists()){
                BufferedReader br = new BufferedReader(new FileReader(file));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

                String line = null;
                int num = Integer.parseInt(args[1]);

                for(int i=0; i<num; i++){
                    line = br.readLine();
                    if(line == null) break;
                    pw.println((i+1)+" : "+line);
                }

                br.close();
                pw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
