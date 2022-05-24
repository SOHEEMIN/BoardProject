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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="./layout/header.jsp" flush="false"></jsp:include>
<div class="container">
    <h2 class="display-4 fw-normal">save.jsp</h2>
    <div class="py-5 text-center">
<h2>상세조회</h2><br>
글번호: ${board.id}<br>
조회수: ${board.boardHits}<br>
작성일: ${board.boardCreatedDate}<br>
작성자: ${board.boardWriter}<br>
글제목: ${board.boardTitle}<br>
글내용: ${board.boardContents}<br>
<img src="${pageContext.request.contextPath}/upload/${board.boardFileName}" alt="" height="100" width="100">
<button class="btn btn-primary" onclick="boardUpdate()">글 수정</button> &nbsp;&nbsp;
<button class="btn btn-primary" onclick="boardDelete()">글 삭제</button> &nbsp;&nbsp;
<button class="btn btn-primary" onclick="findAll()">글 목록</button> &nbsp;&nbsp;
    </div>
</div>
</body>
<script>
    const boardUpdate = () => {
        location.href = "/board/update?id=${board.id}"
    }
    const boardDelete = () => {
        location.href = "/board/passwordCheck?id=${board.id}"
    }
    const findAll = () => {
        location.href = "/board/findAll";

    }
</script>
</html>
