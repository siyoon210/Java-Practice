package my.examples.board.servlet;

import my.examples.board.dao.BoardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //글쓰기를 위한 jsp를 포워딩한다
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/boardwrite.jsp");//실제 WAS환경에서는 root다음에 바로 /WEB-INF가 존재한다.
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        //입력받은 제목 이름 내용 ... 을 받는다
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        //입력 받은 내용을 검사한다.- 하나라도 null일경우 바로 리다이렉트
        if (name==null || title==null || content==null){
            resp.sendRedirect("/board/list");
            return;
        }

        BoardArticle boardArticle = new BoardArticle(name, title, content);


        //DB에 저장한다.
        BoardDao boardDao = new BoardDao();
        boardDao.addBoardArticle(boardArticle);

        //리다이렉트 한다
        resp.sendRedirect("/board/list");
    }
}
