<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-24
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>passwordCheck.jsp</h2>
<form action="/board/update" method="post" name="updateForm">
    <input type="text" name="id" value="${boardUpdate.id}" class="form-control" readonly>
    <input type="text" name="boardTitle" value="${boardUpdate.boardTitle}" class="form-control">
    <input type="text" name="boardPassword" id= "passwordConfirm" class="form-control">
    <input type="text" name="boardWriter" value="${boardUpdate.boardWriter}" class="form-control" readonly>
    <input type="text" name="boardContents" value="${boardUpdate.boardContents}" class="form-control">
    <textarea name="boardContents" cols="30" rows="10">${boardUpdate.boardContents}</textarea>
    <input type="button" class="btn btn-danger" onclick="boardUpdate()" value="수정">

</form>
</body>
<script>
    const boardUpdate = () => {
        let passwordConfirm = document.querySelector("#passwordConfirm").value;
                                        //쿼리셀렉터: id와 class를 다 받아줌 (ex. getElementById와 같음. id는 # / class는 . )
        const passwordDB = '${boardUpdate.boardPassword}';
        console.log(passwordConfirm)
        console.log(passwordDB)
        if (passwordConfirm == passwordDB) {
            updateForm.submit();
        } else {
            alert("비밀번호 불일치!!!!!");
            // 일치하지 않으면 상세조회 화면으로
        }
    }
</script>
</html>
