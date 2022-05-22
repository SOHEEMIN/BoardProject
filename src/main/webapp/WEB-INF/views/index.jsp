<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        .container {
            max-width: 1000px;
        }
    </style>
</head>
<body>
<h2>index.jsp</h2>
<a href="/write-form">글쓰기</a><br>
<div class="container">
    <table class="table">
        <tr>
            <th>글번호</th>
            <th>제 목</th>
            <th>글쓴이</th>
            <th>작성일</th>
            <th>조회수</th>
            <th>글내용</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.boardId}</td>
            <td>${board.boardTitle}</td>
            <td>${board.boardName}</td>
            <td>${board.boardDate}</td>
            <td>${board.boardHits}</td>
            <td>${board.boardContents}</td>
        </tr>
        </c:forEach>

    </table>

</div>

</body>
</html>
