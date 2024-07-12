<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/find_id.css">
<script type="text/javascript" src="../resources/js/member.js"></script>
<title>아이디 찾기</title>
</head>
<body>
	<div class="wrap">
        <div class="find_id_wrap">
            <h2>아이디 찾기</h2>
            <form id="findIdForm" name = "findIdForm" action="${contextPath }" method="post">
                <input type="text" name="name" id="name" placeholder="이름">
                <input type="email" name="email" id="email" placeholder="이메일">
                <!-- 아이디 찾기 클릭 시 데이터베이스의 회원 정보와 일치한다면 팝업창으로 ID 출력, 일치 하지 않는다면 alert창으로 불일치 출력 -->
                <input type="button" id="id_find" onclick = "idFind()" value="아이디 찾기">
            </form>

            <ul class = "find_id_ul_wrap">
                <li>
                    <a target = "_blank" href = "joinForm.do" class = "join">회원가입</a>
                </li>
                <li>
                	<a target = "_blank" href = "findPwd.do" class = "pwdfind">비밀번호 찾기</a>
                </li>
                <li>
                    <a target="_blank" href="loginForm.do" class = "login">로그인 하기</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>