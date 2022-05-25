<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2022-05-21
  Time: 오후 7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>write</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
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
        <button class="btn btn-primary" onclick="findAll()">글 목록</button> &nbsp;
        <button class="btn btn-primary" onclick="paging()">페이징목록</button> &nbsp;
        <div class="container">
            <div id="commit-write" class="input-group- mb-3">
                <input type="text" id="commentWriter" class="form-control" placeholder="작성자">
                <input type="text" id="commentContents" class="form-control" placeholder="내용">
                <button id="comment-write-btn" class="btn btn-danger">댓글작성</button>
            </div>
        </div>

        <div id="comment-list">
            <table class="table">
                <tr>
                    <th>댓글번호</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>작성시간</th>
                </tr>
                <c:forEach items="${commentList}" var="comment">
                    <tr>
                        <td>${comment.id}</td>
                        <td>${comment.commentWriter}</td>
                        <td>${comment.commentContents}</td>
                        <td>${comment.commentCreatedDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
<script>
    $("#comment-write-btn").click(function () {
        //댓글 작성자, 내용을 가져오고 ajax 문법을 활용하여 /comment/save 주소로 post방식으로 작성자, 내용, 글번호
        //세개의 값을 보내는 코드를 작성하시오
        const commentWriter = document.getElementById("commentWriter").value;
        const commentContents = $("#commentContents").val();
        const boardId = '${board.id}';
        console.log(commentWriter, commentContents, boardId)
        $.ajax({
            type: "post",
            url: "/comment/save",
            data: {
                "commentWriter": commentWriter,
                "commentContents": commentContents,
                "boardId": boardId
            },
            dataType: "json",
            success: function (result) {
                console.log(result);
                let output = "<table class='table'>";
                output += "<tr><th>댓글번호</th>";
                output += "<th>작성자</th>";
                output += "<th>내용</th>";
                output += "<th>작성시간</th></tr>";
                for(let i in result){
                    output += "<tr>";
                    output += "<td>"+result[i].id+"</td>";
                    output += "<td>"+result[i].commentWriter+"</td>";
                    output += "<td>"+result[i].commentContents+"</td>";
                    output += "<td>"+result[i].commentCreatedDate+"</td>";
                    output += "</tr>";
                }
                output += "</table>";
                document.getElementById('comment-list').innerHTML = output;
                document.getElementById('commentWriter').value='';
                document.getElementById('commentContents').value='';
            },
            error: function () {
                alert("어디가 틀렸을까");
            }
        });
    });

    const paging = () => {
        location.href = "/board/paging?page=${page}"; //직전에 있었던 페이지 값을 컨트롤러로 요청
    }
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
