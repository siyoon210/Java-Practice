package my.examples.board.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/content")
public class BoardContentServlet extends HttpServlet {
    private int cid;

    public int getCid() {
        return cid;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //요청한 값을 확인한다.

        //요청한 파라미터의 아이디 값을 확인한다.
        cid = Integer.parseInt(req.getParameter("cid"));

        //아이디 값에 맞는 글 내용을 보여준다. 글보여주는 곳으로 포워드
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/boardContent.jsp");
        dispatcher.forward(req, resp);
    }
}
