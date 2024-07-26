<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="../header.jsp"%>
    
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #fff;
        margin: 0;
    }

    #updateForm {
        background-color: #ffffff;
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    input[type="text"], textarea {
        width: 100%;
        padding: 10px;
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
</style>
<title>게시글 수정</title>
</head>
<body>
	<form id="updateForm">
	    <input type="hidden" value="${board.boardId}" name="boardId" id="boardId">
	    
	    <div class="form-group">
	        <label for="subject">제목:</label>
	        <input type="text" placeholder="제목" id="title" name="title" value="${board.title}">
	    </div>
	    
	    <div class="form-group">
	        <label for="name">작성자:</label>
	        <input type="text" placeholder="작성자" id="memberId" name="memberId" readonly="readonly" value="${board.memberId}">
	    </div>
	    
	    <div class="form-group">
	        <label for="content">내용:</label>
	        <textarea placeholder="내용" id="boardContent" name="boardContent">${board.boardContent}</textarea>
	    </div>
	    
	    <button type="button" onclick="boardUpdate();">수정</button>
	</form>



<%@ include file="../footer.jsp"%>