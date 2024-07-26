<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<%@ include file="../header.jsp"%>    

<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<title>${board.boardContent}</title>
	<style>
    body {
        font-family: Arial, sans-serif;
        line-height: 1.6;
        margin: 0;
        background-color: #fff;
    }

    #viewForm {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        padding: 20px;
        max-width: 800px;
        margin: 0 auto;
    }

    .post-header {
        border-bottom: 1px solid #eee;
        padding-bottom: 10px;
        margin-bottom: 20px;
    }

    .post-title {
        font-size: 24px;
        color: #333;
        margin-bottom: 10px;
    }

    .post-info {
        font-size: 14px;
        color: #666;
    }

    .post-content {
        margin-bottom: 20px;
    }

    .btn {
        display: inline-block;
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
	<form id="viewForm">
		<input type = hidden value = "" name = "boardId" id = "boardId">
        <div class="post-header">
            <h1 class="post-title">${board.title}</h1>
            <p class="post-info">
                작성자: ${board.memberId} | 조회수: ${board.views}
            </p>
        </div>
        <div class="post-content">
            ${board.boardContent}
        </div>
        <button type="button" class="btn" onclick='location.href="${contextPath}/community/board.do"'>목록</button>
        <button type="button" class="btn" onclick="goUpdateBoard(${board.boardId})">수정</button>
        <button type="button" class="btn" onclick="deleteBoard(${board.boardId})">삭제</button>
    </form>




<%@ include file="../footer.jsp"%>