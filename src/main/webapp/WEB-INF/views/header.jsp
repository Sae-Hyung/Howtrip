<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/main.css">
<script src="https://cdn.tailwindcss.com" type="text/javascript"></script>
<title>여행 어때?</title>
</head>
<body>
	<header class="bg-gray-200 h-32">
		<div class="mx-auto max-w-screen-xl px-4 sm:px-6 lg:px-8">
			<div class="flex h-16 items-center justify-between">
				<div class="md:flex md:items-center md:gap-12">
					<a class="block text-teal-600" href="${contextPath}"> <span
						class="sr-only">Home</span> <img
						src="resources/img/HowTrip_logo.png" alt="여행 어때?">
					</a>
				</div>

				<div class="flex items-center gap-4">
					<div class="sm:flex sm:gap-4">
						<c:choose>
							<c:when test="${isLogOn == true && member != null}">
								<span>${member.name}님 환영합니다. </span>
								<a href="#none">마이페이지</a>
								<a href="${contextPath}/member/logout.do">로그아웃</a>
							</c:when>
							<c:when test="${signIn != null}">
								<span>아이디 : ${name}</span>
								<a href="#none">마이페이지</a>
								<a href="${contextPath}/member/sociallogout">로그아웃</a>
							</c:when>
							<c:otherwise>
								<a
									class="rounded-md bg-teal-600 px-5 py-2.5 text-sm font-medium text-white shadow"
									href="${contextPath}/member/loginForm.do"> 로그인 </a>

								<div class="hidden sm:flex">
									<a
										class="rounded-md bg-gray-100 px-5 py-2.5 text-sm font-medium text-teal-600"
										href="${contextPath}/member/joinForm.do"> 회원가입 </a>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

					<div class="block md:hidden">
						<button
							class="rounded bg-gray-100 p-2 text-gray-600 transition hover:text-gray-600/75">
							<svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5"
								fill="none" viewBox="0 0 24 24" stroke="currentColor"
								stroke-width="2">
                                <path stroke-linecap="round"
									stroke-linejoin="round" d="M4 6h16M4 12h16M4 18h16" />
                            </svg>
						</button>
					</div>
				</div>
			</div>

			<div class="hidden md:block">
				<nav aria-label="Global">
					<ul class="flex px-40 items-center text-sm justify-evenly">
						<li><a class="text-xl text-black-500 transition hover:text-gray-500/75" href="${contextPath}"> HOME </a></li>

						<li class="relative group w-48">
							<a class="text-xl text-black-500 transition hover:text-gray-500/75"	href="#"> 여행지 </a>
							<div class="absolute left-0 w-48 bg-white rounded-md shadow-lg opacity-0 group-hover:opacity-100 group-hover:visible transition-opacity duration-300 invisible">
								<a href="#"	class="block px-4 py-2 text-black hover:bg-blue-200 hover:rounded-t-md">여행지 추천</a> 
								<a href="#"	class="block px-4 py-2 text-black hover:bg-blue-200">여행지 코스 추천</a> 
								<a href="#"	class="block px-4 py-2 text-black hover:bg-blue-200 hover:rounded-b-md">여행	지도</a>
							</div>
						</li>

						<li><a
							class="text-xl text-black-500 transition hover:text-gray-500/75"
							href="${contextPath}/community/board.do"> 커뮤니티 </a></li>

						<li class="relative group w-48">
							<a class="text-xl text-black-500 transition hover:text-gray-500/75"	href="#"> 공지사항 </a>
							<div class="absolute left-0 w-48 bg-white rounded-md shadow-lg opacity-0 group-hover:opacity-100 group-hover:visible transition-opacity duration-300 invisible">
								<a href="#"	class="block px-4 py-2 text-black hover:bg-blue-200 hover:rounded-t-md">이벤트</a>
								<a href="#" class="block px-4 py-2 text-black hover:bg-blue-200">서비스 업데이트 내역</a> 
								<a href="#"	class="block px-4 py-2 text-black hover:bg-blue-200 hover:rounded-b-md">게시판 이용 규칙</a>
							</div>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</header>