<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #fff;
        margin: 0;
    }

    #frm {
        background-color: #ffffff;
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    input[type="text"], textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[readonly] {
        background-color: #f0f0f0;
    }

    textarea {
        height: 150px;
        resize: vertical;
    }

    button {
        background-color: #007bff;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    button:hover {
        background-color: #0056b3;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
	</style>
	<title>게시글 작성하기</title>
	<script type="text/javascript">
	function fn_boardRegi(){
		$.ajax({
			type : "POST",
			url : "${contextPath}/community/board/write",
			data : {"title" : $("#title").val(),
					"memberId" : $("#memberId").val(),
					"boardContent" : $("#boardContent").val()},
			success: function(data){
				if(data == 0){
					alert("게시글의 제목을 입력해 주세요.");
					$("#title").focus();
				} else if(data == 1) {
					alert("내용을 작성해 주세요.");
					$("#boardContent").focus();
				} else{
					alert("글 등록이 완료되었습니다.");
					location.href = "${contextPath}/community/board.do";
				}
			},
			error: function(data){
				alert("실패");
				console.log(data);
			}
		});
	};
	</script>
	</head>
	<body>
		<form id="frm">
		    <div class="form-group">
		        <label for="title">제목</label>
		        <input type="text" placeholder="제목" id="title" name="title">
		    </div>
		    <div class="form-group">
		        <label for="memberId">작성자</label>
		        <input type="text" id="memberId" name="memberId" value="${member.memberId}" readonly>
		    </div>
		    <div class="form-group">
		        <label for="boardContent">내용</label>
		        <textarea placeholder="내용" id="boardContent" name="boardContent"></textarea>
		    </div>
		    <button type="button" onclick = 'location.href = "${contextPath}/community/board.do"'>취소</button>
		    <button type="button" onclick="fn_boardRegi();">등록</button>
		</form>

<%@ include file="../footer.jsp"%>