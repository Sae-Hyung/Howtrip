<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/join.css">

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input {
            display: block;
            margin: 10px 0;
            padding: 5px;
            width: 200px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
<title>회원가입</title>
</head>
<body>
	<form action = "${contextPath}/member/join.do" method = "post">
        <h2>회원가입</h2>
        <input type="text" name = "userId" placeholder="아이디" required>
        <input type="password" name = "userPw" placeholder="비밀번호" required>
        <input type="password" name = "userPwCheck" placeholder="비밀번호 확인" required>
        <input type="text" name = "name" placeholder="이름" required>
        <input type="date" name = "birth" placeholder="생년월일" required>
        <input type="text" name = "gender" placeholder="성별" required>
        <input type="email" name = "email" placeholder="이메일" required>
        <input type="text" name = "tel" placeholder="전화번호">
        <button type="reset">다시입력</button>
        <button type="submit">가입하기</button>
    </form>
</body>
</html>

