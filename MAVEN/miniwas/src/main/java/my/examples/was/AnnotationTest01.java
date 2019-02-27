package my.examples.was;

import my.examples.was.annotation.WebServlet;

import java.io.PrintWriter;

@WebServlet("/mypath")
public class AnnotationTest01 extends HttpServlet{
    @Override
    public void doGet(Request request, Response response) {
        PrintWriter out = response.getPw();
        for(int i = 0; i < 10; i++)
            out.println("<h1>hello</h1>");
    }

}
