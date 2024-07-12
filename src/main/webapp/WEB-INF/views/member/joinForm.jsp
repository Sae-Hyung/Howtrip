<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/join.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<script type="text/javascript">
function idCheck() { // ajax 비동기 통신을 이용하여 아이디 중복체크 작업 수행
	$.ajax({
		url : "${contextPath}/member/idcheck.do",
		type : "post",
		dataType : "json", // json 타입으로 데이터를 전달 받는다.
		data : {
			"userId" : $("#userId").val() // userId라는 매개변수명으로 아이디 값을 전달한다.
		},
		success : function(data) { // IdCheckController에서 반환한 data 값을 이용해서 아이디 중복을 확인한다. data = idCheck 메서드의 result 값
			if (data == 0) {
				if ($("#userId").val() == "" || $("#userId").val() == null) {
					alert("아이디를 입력해주세요");
				} else {
					$("#idChk").attr("value", "Y"); // 아이디가 #idChk인 태그의 value 값을 "Y"로 설정
					alert("사용가능한 아이디입니다.");
				}
			} else if (data == 1) {
				alert("중복된 아이디입니다.");
			} else if (data == 2) {
				alert("아이디의 길이는 6 ~ 20자 이어야 합니다.")
			} else {
				alert("영어, 숫자 이외의 문자는 사용할 수 없습니다.")
			}
		}
	});
}
</script>
<title>회원가입</title>
</head>
<body>
	<form action="${contextPath}/member/join.do" method="post" name = "formJoin">
		<h2>회원가입</h2>
		<input type="text" name="userId" id="userId" onkeyup = "idEvent()" placeholder="아이디" required>
		<div class="success-message hide">사용할 수 있는 아이디입니다</div>
    	<div class="failure-message hide">아이디는 6~20글자이어야 합니다</div>
    	<div class="failure-message2 hide">영어 또는 숫자만 가능합니다</div>
		<button type="button" name="reId" id="idChk" value = "N" onclick="idCheck()">중복확인</button>
		<input type="password" name="userPw" id = "userPw" onkeyup = "passwordEvent()" placeholder="비밀번호" required>
		<div class="password-message hide">비밀번호는 8 ~ 20자 사이어야 합니다, 영문, 숫자, 특수문자(@$!%*#?&)를 필수로 사용하여야 합니다.</div>
		<input type="password" name="userPwCheck" id = "userPwCheck" onkeyup = "passwordReEvent()" placeholder="비밀번호 확인" required> 
		<div class="mismatch-message hide">비밀번호가 일치하지 않습니다</div>
		<input type="text" name="name" placeholder="이름" required> 
		<input type="date" name="birth" placeholder="생년월일" required> 
		<select name="gender" placeholder="성별" required>
			<option value = "">성별을 선택해 주세요</option>
			<option value = "male">남</option>
			<option value = "female">여</option>
		</select> 
		<input type="email" name="email" placeholder="이메일" required>
		<input type="text" name="tel" placeholder="전화번호">
		<button type="button" onclick = "joinCancle()">취소</button>
		<button type="button" onclick = "join();">가입하기</button>
	</form>
</body>
<script type="text/javascript" src="../resources/js/member.js"></script>
</html>

