package my.examples.was;

import java.io.*;

public class DefaultServlet {
    public void service(Request request, Response response){
        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();

        String path = request.getPath();
        if(path.equals("/")){
            path += "index.html";
        }
        File file = new File("tmp"+path);

        if (file.exists()) {
            //HTTP 응답 프로토콜 전송 시작
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: "+ file.length());
            pw.println("");
            pw.flush();

            //Body부분 시작
            try {
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[512];
                int readCount = 0;
                while((readCount = fis.read(buffer))!=-1){
                    out.write(buffer,0,readCount);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        } else {
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();
        }


    }
}
