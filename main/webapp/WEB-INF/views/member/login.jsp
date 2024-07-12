<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
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
            <h2>여행어때?</h2>
            <ul class = "menu_wrap">
                <li class = "menu_item">
                    <a href="#none" id="loinid" class="menu_id" aria-selected="false">
                        <span class="menu_text"><span class="text">일반 로그인</span></span>
                    </a>                
                </li>
                <li class = "menu_item">
                    <a href="#none" id="ones" class="menu_social" aria-selected="false">
                        <span class="menu_text"><span class="text">소셜 로그인</span></span>
                    </a>
                </li>
            </ul>

            <form class="frm_login" name="formLogin" method="post">
                <input type="text" name="userId" placeholder="아이디"><br>
                <input type="password" name="userPwd" placeholder="비밀번호"><br>
                <label for="remember-check">
                    <input type="checkbox" name = "idRememberBox" id="remember-check">아이디 저장하기
                </label>
                <br><br>
                <!-- memeber.js파일에서 로그인이 유효한지 검사하고 메인페이지(index.jsp)로 이동 -->
                <input type="button" class = "frm_login_submit" onclick = "loginCheck()" value = "로그인">
            </form>

            <ul class = "find_wrap">
                <li>
                    <a target = "_blank" href = "findId.do" class = "find_text">아이디 찾기</a>
                </li>
                <li>
                    <a target = "_blank" href="findPwd.do" class = "find_text">비밀번호 찾기</a>
                </li>
                <li>
                    <a target="_blank" href="join.do" class = "join">회원가입</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>