package my.examples.was;

import java.util.HashMap;
import java.util.List;

public class Request{
    private String methodName;
    private String pathName;
    private HashMap headerInfos;

    private DefaultServlet defaultServlet;

    public Request(List<String> requestInfos) {
        setRequestFields(requestInfos);
    }

    public void setRequestFields(List<String> requestInfos){
        String[] firstLine = requestInfos.get(0).split(" ");

        //메소드 이름 설정
        this.methodName = firstLine[0];

        //패스 설정
        this.pathName = firstLine[1];

        if(this.pathName.contains("?")){ //파라미터 값이 있는경우
            int pos= this.pathName.indexOf("?");
            this.pathName = this.pathName.substring(0,pos); //? 앞까지만 자름
            return;
        }

        //헤더 인포 설정
        headerInfos = new HashMap();
        for(int i=1; i<requestInfos.size(); i++){
            String[] tmp= requestInfos.get(i).split(":");

            if(tmp.length ==2) {
                headerInfos.put(tmp[0].trim(), tmp[1].trim());
            }
            else if(tmp.length ==3){ //Host의 포트번호가 80이 아닐경우, 3개로 나누어 진걸 다시 붙인다.
                headerInfos.put(tmp[0].trim(), tmp[1].trim().concat(":").concat(tmp[2].trim()));
            }

        }
    }

    public void requestToServlet(){
        DefaultServlet defaultServlet =new DefaultServlet();
        defaultServlet.logicHandling(this);

        this.defaultServlet = defaultServlet;
    }

    public DefaultServlet getDefaultServlet() {
        return defaultServlet;
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

}
