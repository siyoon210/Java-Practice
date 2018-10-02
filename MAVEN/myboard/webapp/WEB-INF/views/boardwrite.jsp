<%--
  Created by IntelliJ IDEA.
  User: siyoon
  Date: 18. 10. 2
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>게시판 - 글쓰기</title>
</head>
<body>
<div class="container">
<h3>게시판 글쓰기</h3>
<div>
    <form method="post" action="/board/write">
        <div class="form-group"><label for="name">이름</label><input class="form-control" type="text" name="name" id="name" required> </div>
        <div class="form-group"><label for="title">제목</label><input class="form-control" type="text" name="title" id="title" required> </div>
        <div class="form-group"><label for="content">내용</label><textarea class="form-control" id="content" name="content" rows="5" required></textarea></div>
        <button type="submit" class="btn btn-primary">글쓰기</button>
    </form>
</div>
</div>
</body>
</html>
