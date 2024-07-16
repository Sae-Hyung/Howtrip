<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/login.css">
<script type="text/javascript" src="../resources/js/member.js"></script>
<title>로그인</title>
</head>
<body>
	<div class = "wrap">
        <div class="login_wrap">
            <a href = "${contextPath}">
            	<h2>여행어때?</h2>
            </a>
            <ul class = "menu_wrap">
                <li class = "menu_item">
                    <a href="${contextPath}/member/loginForm.do" id="loinid" class="menu_id" aria-selected="false">
                        <span class="menu_text"><span class="text">일반 로그인</span></span>
                    </a>                
                </li>
                <li class = "menu_item">
                    <a href="${contextPath}/member/socialLoginForm.do" id="ones" class="menu_social" aria-selected="false" >
                        <span class="menu_text"><span class="text">소셜 로그인</span></span>
                    </a>
                </li>
            </ul>
			<!-- 로그인 영역 -->
            <form class="frm_login" name="formLogin" action = "${contextPath}/member/login.do" method="post">
                <input type="text" name="userId" placeholder="아이디"><br>
                <input type="password" name="userPw" placeholder="비밀번호"><br>
                <label for="remember-check">
                    <input type="checkbox" name = "idRememberBox" id="remember-check">아이디 저장하기
                </label>
                <br><br>
                <!-- memeber.js파일에서 로그인이 유효한지 검사하고 메인페이지(index.jsp)로 이동 -->
                <input type="button" class = "frm_login_submit" onclick = "loginCheck()" value = "로그인">
            </form>
			<!-- 아이디/비밀번호 찾기 및 회원가입 영역 -->
            <ul class = "find_wrap">
                <li>
                    <a target = "_blank" href = "${contextPath}/member/findId.do" class = "find_text">아이디 찾기</a>
                </li>
                <li>
                    <a target = "_blank" href="${contextPath}/member/findPwd.do" class = "find_text">비밀번호 찾기</a>
                </li>
                <li>
                    <a target="_blank" href="${contextPath}/member/joinForm.do" class = "join">회원가입</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>
