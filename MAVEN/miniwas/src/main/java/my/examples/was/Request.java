package my.examples.was;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request{
    private InputStream in;
    private BufferedReader br;
    private String method;
    private String path;
    private Map<String, String> headers;

    public Request(InputStream in, BufferedReader br) {
        this.in = in;
        this.br = br;

        try {
            String[] requestLine = br.readLine().split(" ");
            method = requestLine[0];
            path = requestLine[1];
            if(path.contains("?")){
                int pos = path.indexOf("?");
                path = path.substring(0, pos);
            }

            String line = null;
            headers = new HashMap<>();
            while ((line = br.readLine())!=null){
                if(line.equals("")) break; //빈줄이라면 반복종료
                int pos = line.indexOf(":");
                headers.put(line.substring(0, pos), line.substring(pos+1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }//Constructor

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
