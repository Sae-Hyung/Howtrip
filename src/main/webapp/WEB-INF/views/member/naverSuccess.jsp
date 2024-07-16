<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script type="text/javascript"
  src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
  charset="utf-8"></script>
<script type="text/javascript"
  src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">
html, div, body, h3 {
  margin: 0;
  padding: 0;
}

h3 {
  display: inline-block;
  padding: 0.6em;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var name = "${name}";
		var email = "${email}";
		$("#name").html(name);
		$("#email").html(email);
		 });
</script>
</head>
<body>
    <section class="bg-light">
        <div class="container py-4">
            <div class="row align-items-center justify-content-between">
                <a class="navbar-brand h1 text-center" href="index.do">
                    <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>                 
                </a>
            </div>
            <div>
            	<h1 class ="text-dark text-center">환영합니다!</h1>
            	<p class="text-center"> 
            		<span id="name"></span>님의 로그인 성공<br> 이메일 주소는 <strong id="email"></strong>입니다.
            	</p>
            </div>
            <div class="d-grid gap-2">
           		<button type="button" class="btn btn-primary btn-lg" onclick="location.href='index.do'">시작하기</button>
            </div>
        </div>
    </section>
</body>
</html>