<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2022-05-21
  Time: 오후 7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>write</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h2>글쓰기</h2>
<form action="/write" method="post">
    <p>글번호</p>
    <input type="text" name="boardID" placeholder="글번호" readonly>
    <p>글제목</p>
    <input type="text" name="boardTitle" placeholder="글제목">
    <p>작성자</p>
    <input type="text" name="boardName" placeholder="작성자">
    <p>작성일</p>
    <input type="text" name="boardDate" placeholder="작성일" readonly>
    <p>글내용</p>
    <input type="text" name="boardContents" placeholder="글내용">
    <input type="submit" value="작성">

</form>
</body>
</html>
