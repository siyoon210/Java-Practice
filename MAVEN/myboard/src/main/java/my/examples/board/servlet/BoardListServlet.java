package my.examples.board.servlet;

import my.examples.board.dao.BoardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 브라우저가 /board/list 라는 요청을 했을 경우 게시판 목록을 보여준다.

        //DB에서 목록을 읽어온다.
        BoardDao boardDao = new BoardDao();
        List<BoardArticle> boardList = boardDao.getBoardList();
        req.setAttribute("boardList", boardList);

        //게시판 목록을 보여주는 JPS파일을 포워딩
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/boardlist.jsp");
        dispatcher.forward(req,resp); //포워딩 받은 jsp도 결국 서블릿이므로, req, resp를 담아서 포워딩해준다.
        //RequestDispatcher를 사용하여 포워딩 하는 문법패턴 (암기사항)
    }
}
