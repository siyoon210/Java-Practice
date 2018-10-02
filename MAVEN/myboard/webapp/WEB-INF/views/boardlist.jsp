<%@ page import="my.examples.board.dao.JDBCForList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: siyoon
  Date: 18. 10. 2
  Time: 오후 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>게시판 목록</title>
</head>
<body>
<div class="container">
<h3>게시판 목록</h3>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">
                    글번호
                </th>
                <th scope="col">
                    제목
                </th>
                <th scope="col">
                    글쓴이
                </th>
                <%--<th scope="col">--%>
                    <%--내용--%>
                <%--</th>--%>
            </tr>
            </thead>
            <tbody>
                <%
                    my.examples.board.dao.JDBCForList jdbc = new JDBCForList();
                    jdbc.run();
                    List boardList = jdbc.getBoardList();

                    for(int i=boardList.size()-1; i>=0; i--){
                        Map boardContent = new HashMap();
                        boardContent = (Map)boardList.get(i);
                        out.print("<tr>");
                        out.print("<th scope=\"row\"><span>");
                        out.print(boardContent.get("cid"));
                        out.print("</span></th>");
                        out.print("<td><a href=\"/board/content?cid="+boardContent.get("cid")+"\"><span>");
                        out.print(boardContent.get("title"));
                        out.print("</span></a></td>");
                        out.print("<td><span>");
                        out.print(boardContent.get("name"));
                        out.print("</span></td>");
//                        out.print("<td><span>");
//                        out.print(boardContent.get("content"));
//                        out.print("</span></td>");
                        out.print("</tr>");
                    }
                %>
            </tr>
            </tbody>
        </table>

    </div>
    <div>
        <a class="btn btn-primary" role="button" href="/board/write">글쓰기</a>
    </div>
</div>
</body>
</html>
