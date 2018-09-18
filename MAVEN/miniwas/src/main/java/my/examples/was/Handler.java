package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Handler extends Thread{
    private Server server;
    private Socket socket;

    private List<String> requestInfos;
    private String methodName;
    private String pathName;
    private HashMap headerInfos = new HashMap();

    public Handler(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    public void setMethodName(List<String> requestInfos){
        String[] firstLine = requestInfos.get(0).split(" ");
        this.methodName = firstLine[0];
    }

    public void setPathName(List<String> requestInfos){
        String[] firstLine = requestInfos.get(0).split(" ");
        this.pathName = firstLine[1];

        if(this.pathName.contains("?")){ //파라미터 값이 있는경우
             int pos= this.pathName.indexOf("?");
             this.pathName = this.pathName.substring(0,pos); //? 앞까지만 자름
            return;
        }

    }

    public void setHeaderInfos(List<String> requestInfos) {
        for(int i=1; i<requestInfos.size(); i++){
            String[] tmp= requestInfos.get(i).split(":");

            if(tmp.length ==2) {
                headerInfos.put(tmp[0].trim(), tmp[1].trim());
            }
            else if(tmp.length ==3){
                headerInfos.put(tmp[0].trim(), tmp[1].trim().concat(":").concat(tmp[2].trim()));
            }

        }
    }

    public String getMethodName() {
        return methodName;
    }

    public String getPathName() {
        return pathName;
    }

    public HashMap getHeaderInfos() {
        return headerInfos;
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

            setMethodName(requestInfos);
            setPathName(requestInfos);
            setHeaderInfos(requestInfos);

            System.out.println(getMethodName());
            System.out.println(getPathName());
            System.out.println(getHeaderInfos());

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
