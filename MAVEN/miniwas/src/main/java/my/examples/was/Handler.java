package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Handler extends Thread{
    private Connector connector;
    private Socket socket;

    private List<String> requestInfos;

    private Response response;


    public Handler(Connector connector, Socket socket) {
        this.connector = connector;
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line = null;
            requestInfos = new ArrayList<String>();

            while ((line=in.readLine())!=null){
                requestInfos.add(line);
                if(line.equals("")) { //빈줄이면 반복 종료
                    break;
                }
            }

            Request request = new Request(requestInfos); //리퀘스트로 요청정보 전송
            request.requestToServlet();

            Response response = new Response(request.getDefaultServlet());


            out.println("HTTP/1.0 200 OK\r\n");
            out.println("\r\n");
            out.println("<p>Hello</p>");
            out.println(response.getHandledData());
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
