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
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<h2>글쓰기</h2>
<form action="/board/save" method="post">
    <p>작성자</p>
    <input type="text" name="boardWriter" placeholder="작성자">
    <p>비밀번호</p>
    <input type="text" name="boardPassword" placeholder="비밀번호">
    <p>글제목</p>
    <input type="text" name="boardTitle" placeholder="글제목">
    <p>글내용</p>
    <input type="text" name="boardContents" placeholder="글내용">
    <input type="submit" value="작성">
</form>
</body>
</html>
