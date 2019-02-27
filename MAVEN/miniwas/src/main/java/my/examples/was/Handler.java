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

            String path = request.getPath();
            Class clazz = map.get(path); //서블릿 목록에 패스명으로 설정된 서블릿으로 클래스를 동적으로 받아본다.
            if (clazz != null) { //미리 설정된 서블릿이 있으면
                HttpServlet httpServlet = servletMap.get(path);
                if (httpServlet == null) { //생성된 객체가 업다면
                    try {
                        httpServlet = (HttpServlet) clazz.newInstance();//객체생성
                        httpServlet.init();
                        servletMap.put(path, httpServlet);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-Type: text/html; charset=UTF-8");
                pw.println("");
                httpServlet.service(request, response);
                pw.flush();
            } else { //동적프로그램이 아니라면 그냥 파일을 뿌려줌
                //데이터 서블릿 생성
                DefaultServlet defaultServlet = new DefaultServlet();
                defaultServlet.service(request, response);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                pw.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
