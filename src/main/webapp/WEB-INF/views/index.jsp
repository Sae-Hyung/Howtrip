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
	<div class="cards" id="cards-container">
		<!-- 카드들이 동적으로 추가될 공간 -->
	</div>
</div>


<%@ include file="footer.jsp"%>

<script>
    // 사용자의 현재 위치를 가져오는 함수
    function getUserLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
        } else {
            console.error("Geolocation is not supported by this browser.");
            // 기본 위치로 서울 강남역 좌표 사용
            const defaultLat = 37.4979; // 서울 강남역 위도
            const defaultLon = 127.0276; // 서울 강남역 경도
            fetchTourData(defaultLat, defaultLon);
        }
    }

    // 위치 정보를 성공적으로 가져왔을 때 호출되는 콜백 함수
    function successCallback(position) {
        const lat = position.coords.latitude;
        const lon = position.coords.longitude;
        console.log("lat :", lat, "lon :", lon);
        fetchTourData(lat, lon);
    }

    // 위치 정보를 가져오지 못했을 때 호출되는 콜백 함수
    function errorCallback(error) {
        console.error("Geolocation error:", error.message);
        // 기본 위치로 서울 강남역 좌표 사용
        const defaultLat = 37.4979; // 서울 강남역 위도
        const defaultLon = 127.0276; // 서울 강남역 경도
        console.log("default lat :", lat, "lon :", lon);
        fetchTourData(defaultLat, defaultLon);
    }

    // API 호출 및 데이터 처리
    function fetchTourData(lat, lon) {
        console.log("하이 lat :", lat, "lon :", lon);
        fetch("http://localhost:8080/howtrip/api/tour/location-based-list?lat="+lat+"&lon="+lon)
            .then(response => response.json())
            .then(data => {
                // 받아온 데이터를 바탕으로 카드들을 생성하고 추가
                const cardsContainer = document.getElementById("cards-container");
                cardsContainer.innerHTML = ""; // 기존 카드들 삭제

                data.tourItems.forEach(item => {
                    const card = document.createElement("div");
                    card.className = "card";

                    const img = document.createElement("img");
                    img.src = item.imageUrl;
                    img.alt = item.name;

                    const h3 = document.createElement("h3");
                    h3.textContent = item.name;

                    card.appendChild(img);
                    card.appendChild(h3);
                    cardsContainer.appendChild(card);
                });
            })
            .catch(error => console.error("API 호출 중 오류 발생:", error));
    }

    // 페이지 로딩 시 사용자의 위치를 가져오기 위해 함수 호출
    getUserLocation();
</script>