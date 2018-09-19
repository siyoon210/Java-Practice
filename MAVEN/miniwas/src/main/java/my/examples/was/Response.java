package my.examples.was;

public class Response {
    private DefaultServlet defaultServlet;
    private String handledData;

    public Response(DefaultServlet defaultServlet) {
        this.handledData = defaultServlet.getHandledData();
    }

    public String getHandledData() {
        return handledData;
    }
}
