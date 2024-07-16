<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>

<div class="container">
	<div class="main-header">
		<h1>웹 서비스 소개</h1>
		<p>
			<strong>size</strong> 설정 필요
		</p>
	</div>
	<div class="cards">
		<div class="card">
			<h3>부평시장 맛집추천!</h3>
			<div class="user-info">
				<img src="resources/img/profile.jpg" alt="사용자 사진">
				<div class="user-details">
					<span class="name">라이언</span>
				</div>
			</div>
		</div>
		<div class="card">
			<h3>부평 해물탕거리 찐맛집 남해해물탕 해물찜 후기</h3>
			<div class="user-info">
				<img src="resources/img/profile.jpg" alt="사용자 사진">
				<div class="user-details">
					<span class="name">어피치</span>
				</div>
			</div>
		</div>
		<div class="card">
			<h3>그냥 지나치기 힘든 먹거리로 가득한, 부평종합시장</h3>
			<div class="user-info">
				<img src="resources/img/profile.jpg" alt="사용자 사진">
				<div class="user-details">
					<span class="name">제이지</span>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="main-header">
		<h1>내 주변 여행지 추천</h1>
	</div>
	<div class="cards">
		<div class="card">
			<img
				src="resources/img/Bupyeongmarket.jpg"alt="부평시장">
			<h3>부평시장</h3>
		</div>
		<div class="card">
			<img
				src="resources/img/BupyeongGeneralMarket.jpg" alt="부평 종합시장">
			<h3>부평 종합시장</h3>
		</div>
		<div class="card">
			<img
				src="resources/img/BupyeongSeafoodStreet.jpg" alt="부평 해물탕거리">
			<h3>부평 해물탕거리</h3>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>