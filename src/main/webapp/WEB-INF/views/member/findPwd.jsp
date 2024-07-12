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
<link rel="stylesheet" href="../resources/css/find_pwd.css"><link>
<script type="text/javascript" src="../resources/js/member.js"></script>
<title>비밀번호 찾기</title>
</head>
<body>
	<div class="wrap">
        <div class="find_pwd_wrap">
            <h2>비밀번호 찾기</h2>
            <form id="findPwdForm" name = "findPwdForm" action="${contextPath }/" method="post">
                <input type="text" name = "userId" placeholder="아이디">
                <input type="text" name="name" id="name" placeholder="이름">
                <input type="email" name="email" id="email" placeholder="이메일">
                <!-- 데이터베이스의 회원 정보와 일치한다면 새 비밀번호 설정 페이지로 이동, 불일치 한다면 alert창을 띄우고 회원 정보 불일치 출력 -->
                <input type="submit" id="pwd_find" onclick="pwdFind(); return false;" value="비밀번호 찾기">
            </form>

            <ul class = "find_pwd_ul_wrap">
                <li>
                    <a target = "_blank" href = "${contextPath}/member/joinForm.do" class = "join">회원가입</a>
                </li>
                <li>
                	<a target = "_blank" href = "${contextPath}/member/findId.do" class = "idfind">아이디 찾기</a>
                </li>              
                <li>
                    <a target="_blank" href="${contextPath}/member/loginForm.do" class = "login">로그인 하기</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>