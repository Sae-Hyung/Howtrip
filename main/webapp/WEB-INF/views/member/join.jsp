<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/join.css">
<title>회원가입</title>
</head>
<body>
	<div class="div-wrapper">
		<div class="div">
			<div class="overlap-3">
				<div class="text-wrapper-10">*아이디</div>
				<div class="text-wrapper-11">회원 정보 입력</div>
			</div>
			<input type="text" class="rectangle-2" id="pwdchk"> 
			<input type="text" class="rectangle-3" id="username">
			<div class="text-wrapper-12">*비밀번호</div>
			<input type="text" class="rectangle-4" id="password">
			<div class="text-wrapper-13">*비밀번호 재확인</div>
			<div class="text-wrapper-14">*성별</div>
			<form action="#">
				<div class="form-group-2">
					<select name="genders" id="gender">
						<option value="gender">성별</option>
						<option value="man">남</option>
						<option value="girl">여</option>
					</select>
				</div>
			</form>
			<div class="text-wrapper-15">*생년월일</div>
			<input type="text" class="label-wrapper" placeholder="년(4자)">

			<form action="#">
				<div class="form-group">
					<select name="months" id="month">
						<option value="month">월</option>
						<option value="January">1월</option>
						<option value="February">2월</option>
						<option value="March">3월</option>
						<option value="April">4월</option>
						<option value="May">5월</option>
						<option value="June">6월</option>
						<option value="July">7월</option>
						<option value="August">8월</option>
						<option value="September">9월</option>
						<option value="October">10월</option>
						<option value="November">11월</option>
						<option value="December">12월</option>
					</select>
				</div>
			</form>

			<input type="text" class="label-wrapper-1" placeholder="일">
			<div class="text-wrapper-16">*이름</div>
			<input type="text" class="rectangle-7" id="name">
			<div class="text-wrapper-17">*이메일</div>
			<input type="text" class="rectangle-5" id="email">
			<div class="text-wrapper-18">휴대전화</div>
			<input type="text" class="rectangle-6" id="phonenum">

			<button class="button overlap-6">
				<div class="text-wrapper-19">취소</div>
			</button>
			<button class="button overlap-7">
				<div class="text-wrapper-20">다음</div>
			</button>
		</div>
	</div>
</body>
</html>

