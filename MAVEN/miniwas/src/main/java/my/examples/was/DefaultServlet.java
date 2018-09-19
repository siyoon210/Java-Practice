package my.examples.was;

public class DefaultServlet {
    private String handledData;
    private Request request;
    private Response response;

    //임의의 로직처리
    public void logicHandling(Request request){

        //받은 인포들의 length와 size를 리턴
        int dataLength = request.getPathName().length()+request.getMethodName().length()+request.getHeaderInfos().size();
        this.handledData =  "<p>sum of requestInfos's length and size : "+dataLength+"</p>";
    }

    public String getHandledData() {

        return handledData;
    }
}
