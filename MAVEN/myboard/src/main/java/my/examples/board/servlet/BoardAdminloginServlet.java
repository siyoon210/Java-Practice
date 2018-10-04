package my.examples.board.servlet;

import sun.misc.Request;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/adminlogin")
public class BoardAdminloginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //로그인 jsp로 포워딩한다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/boardAdminLogin.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");

        if (password.equals("1234")) {
            HttpSession session= req.getSession();
            session.setAttribute("admin","true");
        }

        //목록으로 리다이렉트
        resp.sendRedirect("/board/list");
    }
}
