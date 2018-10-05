package my.examples.was;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Handler extends Thread{
    private static Map<String, Class> map;
    private static Map<String, HttpServlet> servletMap;
    static{
        servletMap = new HashMap<>();
        WebServletMapperManager wsmm = new WebServletMapperManager();
        map = wsmm.findServlet("/home/siyoon/Documents/Java-Practice/MAVEN/miniwas/target/classes/");
    }

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        BufferedReader br = null;
        OutputStream out = null;
        PrintWriter pw = null;


        try {
            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            Request request = new Request(in, br);
            out = socket.getOutputStream();
            pw = new PrintWriter(new OutputStreamWriter(out));
            Response response = new Response(out, pw);

            //데이터 서블릿 생성
            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
                pw.close();

        }
    }
}
