<%@ page import="my.examples.board.dao.JDBCForContent" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: siyoon
  Date: 18. 10. 2
  Time: 오후 6:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>게시판 - 본문</title>
</head>
<body>
<div class="container">
<h3>게시판 본문</h3>
<div>
    <%
        JDBCForContent jdbcForContent = new JDBCForContent();
        Map boardContent = new HashMap();
        boardContent = jdbcForContent.getBoardContent();
        jdbcForContent.run(Integer.parseInt(request.getParameter("cid")));

        out.print("글쓴이 : ");
        out.println(boardContent.get("name"));
        out.print("<br>");
        out.print("제목 : ");
        out.println(boardContent.get("title"));
        out.print("<br>");
        out.print("<br>");
        out.println(boardContent.get("content"));


    %>
    <br>
    <br>
    <a class="btn btn-primary" href ="/board/list">목록으로 </a>

</div>
</div>
</body>
</html>
