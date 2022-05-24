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
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container">
    <h2 class="display-4 fw-normal">save.jsp</h2>
    <div class="py-5 text-center">
<form action="/board/delete" method="post">
    <label for="passwordConfirm">비밀번호를 입력해주세요</label>
    <input type="text" id="passwordConfirm"> <br>
    <input type="button" onclick="passwordCheck()" value="확인">
</form>
</body>
<script>
    const passwordCheck = () => {
        const passwordConfirm = document.getElementById("passwordConfirm").value;
        const passwordDB = '${board.boardPassword}';
        console.log(passwordConfirm)
        console.log(passwordDB)
        if (passwordConfirm == passwordDB) {
            location.href = "/board/delete?id=${board.id}";
        } else {
            alert("비밀번호 불일치!!!!!");
            // 일치하지 않으면 상세조회 화면으로
            location.href = "/board/detail?id=${board.id}";
        }
    }
</script>
</html>






