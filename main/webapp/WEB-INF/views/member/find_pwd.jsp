<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/find_pwd.css"><link>
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
        <div class="find_pwd_wrap">
            <h2>비밀번호 찾기</h2>
            <form id="findForm" action="${contextPath }/" method="post">
                <input type="text" name = "user_id" placeholder="아이디">
                <input type="text" name="name" id="name" placeholder="이름">
                <input type="email" name="email" id="email" placeholder="이메일">
                <input type="submit" id="pwd-find" onclick="findSubmit(); return false;" value="비밀번호 찾기">
            </form>

            <ul class = "find_pwd_ul_wrap">
                <li>
                    <a target = "_blank" href = "#none" class = "join">회원가입</a>
                </li>
                <li>
                    <a target="_blank" href="login.do" class = "login">로그인 하기</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>