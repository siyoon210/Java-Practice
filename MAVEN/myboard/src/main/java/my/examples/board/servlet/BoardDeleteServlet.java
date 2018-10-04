package my.examples.board.servlet;

import my.examples.board.dao.BoardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션을 확인한다.
        HttpSession session = req.getSession();
        if(session.getAttribute("admin")!="true"){
            resp.sendRedirect("/board/list");
            return;
        }
        //글을 삭제한다.
        BoardDao boardDao = new BoardDao();
        System.out.println(req.getParameter("cid"));
        int cid = Integer.parseInt(req.getParameter("cid"));
        boardDao.deleteBoardARticle(cid);

        //리다이렉트 한다.
        resp.sendRedirect("/board/list");
    }
}
