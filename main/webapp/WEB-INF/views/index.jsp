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
			<h3>여행지 간단한 평가</h3>
			<div class="user-info">
				<img src="https://via.placeholder.com/40" alt="사용자 사진">
				<div class="user-details">
					<span class="name">사용자1</span>
				</div>
			</div>
		</div>
		<div class="card">
			<h3>여행지 간단한 평가</h3>
			<div class="user-info">
				<img src="https://via.placeholder.com/40" alt="사용자 사진">
				<div class="user-details">
					<span class="name">사용자2</span>
				</div>
			</div>
		</div>
		<div class="card">
			<h3>여행지 간단한 평가</h3>
			<div class="user-info">
				<img src="https://via.placeholder.com/40" alt="사용자 사진">
				<div class="user-details">
					<span class="name">사용자3</span>
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
				src="https://via.placeholder.com/300x200?text=%EB%B6%80%ED%8F%89%EC%8B%9C%EC%9E%A5"
				alt="부평시장">
			<h3>부평시장</h3>
			<div class="accessibility-icons">
				<img src="https://via.placeholder.com/30?text=🦽"
					alt="Wheelchair Accessible"> <img
					src="https://via.placeholder.com/30?text=👨‍🦯"
					alt="Visually Impaired Accessible">
			</div>
		</div>
		<div class="card">
			<img
				src="https://via.placeholder.com/300x200?text=%EB%B6%80%ED%8F%89%EC%A2%85%ED%95%A9%EC%8B%9C%EC%9E%A5"
				alt="부평 종합시장">
			<h3>부평 종합시장</h3>
			<div class="accessibility-icons">
				<img src="https://via.placeholder.com/30?text=🦽"
					alt="Wheelchair Accessible">
			</div>
		</div>
		<div class="card">
			<img
				src="https://via.placeholder.com/300x200?text=%EB%B6%80%ED%8F%89+%ED%95%B4%EB%AC%BC%ED%83%95%EA%B1%B0%EB%A6%AC"
				alt="부평 해물탕거리">
			<h3>부평 해물탕거리</h3>
			<div class="accessibility-icons">
				<img src="https://via.placeholder.com/30?text=🦽"
					alt="Wheelchair Accessible"> <img
					src="https://via.placeholder.com/30?text=👨‍🦯"
					alt="Visually Impaired Accessible">
			</div>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>