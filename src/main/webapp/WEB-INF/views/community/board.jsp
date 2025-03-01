<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ include file="../header.jsp"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/resources/css/board.css' />">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<form class="table-form">
    <input type="hidden" name="command" value="boardList">
    <fieldset style="text-align: right;">
        <select name="f">
            <option ${param.f == "title" ? "selected" : ""} value="title">제목</option>
            <option ${param.f == "boardContent" ? "selected" : ""} value="boardContent">내용</option>
        </select>
        <input type="text" name="q" value="${param.q}"/>
        <input class="btn btn-search" type="submit" value="검색"/>
    </fieldset>
</form>
<form id = boardForm>
<input type = "hidden" value = "" name = "boardId" id = "boardId">
<table class="table table-hover">
    <thead>
        <tr>
            <th style="width: 5%;" scope="col">글번호</th>
            <th style="width: 60%;" scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성날짜</th>
            <th scope="col">조회수</th>
            <th scope="col">좋아요</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.boardId}</td>
                <td><a href="#" onclick = "goView(${board.boardId})">${board.title}</a></td>
                <td>${board.memberId}</td>
                <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.createdTime}"/></td>
                <td>${board.views}</td>
                <td>${board.likeCnt}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</form>

<!-- loginCheck() 함수를 통해서 로그인 여부를 확인 ajax 사용 -->
<button class="btn btn-light" id = "writeBtn" onclick = "loginCheck()">글쓰기</button>


<!--  페이징처리 -->
<c:set var="page" value="${empty param.p ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page - 1) % 5}" />
<c:set var="lastNum" value="${fn:substringBefore((count + 9) / 10, '.')}" />

<ul style="component-active-bg: gray; justify-content: center;" class="pagination">
    <c:if test="${startNum > 1}">
        <li class="page-item">
            <a style="color: black;" class="page-link" href="BoardServlet?command=board_list&p=${startNum - 1}&f=${param.f}&q=${param.q}" tabindex="-1" aria-disabled="true">이전</a>
        </li>
    </c:if>
    
    <c:forEach var="i" begin="0" end="4">
        <c:if test="${startNum + i <= lastNum}">
            <li class="page-item ${page == (startNum + i) ? 'active' : ''}">
                <a style="${page == (startNum + i) ? 'border-color: lightgray; background: lightgray;' : ''} color: black;" class="page-link" href="BoardServlet?command=board_list&p=${startNum + i}&f=${param.f}&q=${param.q}">${startNum + i}</a>
            </li>
        </c:if>
    </c:forEach>
    
    <c:if test="${startNum + 4 < lastNum}">
        <li class="page-item">
            <a style="color: black;" class="page-link" href="BoardServlet?command=board_list&p=${startNum + 5}&f=${param.f}&q=${param.q}">다음</a>
        </li>
    </c:if>
</ul>


<%@ include file="../footer.jsp"%>

