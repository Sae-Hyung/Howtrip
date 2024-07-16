<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>

<style>
        .container {
            width: 80%;
            margin: 0 auto;
            font-family: Arial, sans-serif;
        }

        .main-header {
            text-align: center;
            margin-bottom: 20px;
        }

        .my-cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .my-card {
            width: 300px;
            margin: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
        }

        .my-card img {
            width: 100%; /* 이미지를 카드의 너비에 맞게 꽉 채웁니다 */
            height: 200px; /* 이미지의 높이를 고정시킵니다 */
            object-fit: cover; /* 이미지가 잘리지 않고 비율을 유지하면서 카드에 맞춥니다 */
            border-radius: 10px 10px 0 0; /* 이미지의 윗 모서리만 라운딩합니다 */
        }

        .my-card h3 {
            font-size: 1.2em;
            margin: 10px 0;
        }

        .my-card p {
            font-size: 0.9em;
            color: gray;
            margin: 0;
        }

        .my-card:hover {
            transform: translateY(-5px);
            box-shadow: 2px 4px 16px rgba(0, 0, 0, 0.2);
        }
    </style>
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
    <div style="font-size:26px;margin-bottom:20px;margin-top:20px">
        내 주변 여행지 추천
    </div>
    <div class="my-cards" id="cards-container">
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
        console.log("default lat :", defaultLat, "lon :", defaultLon);
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
                    card.className = "my-card";

                    const img = document.createElement("img");
                    img.src = item.imageUrl;
                    img.alt = item.name;
                    img.style.height = "200px"; // 이미지 높이를 200px로 제한

                    const h3 = document.createElement("h3");
                    h3.textContent = item.name;
                    h3.style.textAlign = "center"; // 이름을 중앙 정렬

                    const p = document.createElement("p");
                    p.textContent = item.address;
                    p.style.fontSize = "12px"; // 작은 폰트 크기
                    p.style.color = "gray"; // 회색 글씨
                    p.style.textAlign = "center"; // 주소를 중앙 정렬

                    card.appendChild(img);
                    card.appendChild(h3);
                    card.appendChild(p);
                    cardsContainer.appendChild(card);

                    // 카드 클릭 이벤트 추가
                    card.addEventListener("click", () => {
                        const query = encodeURIComponent(item.name); // 이름을 URL에 사용하기 위해 인코딩
                        const url = `https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=`+query;
                        window.location.href = url; // URL로 이동
                    });

                    // 카드에 마우스 호버 시 애니메이션 적용
                    card.addEventListener("mouseenter", () => {
                        card.style.transform = "translateY(-5px)";
                        card.style.boxShadow = "2px 4px 16px rgba(0,0,0,0.2)";
                        card.style.cursor = "pointer"; // 커서를 손가락 모양으로 변경
                    });

                    card.addEventListener("mouseleave", () => {
                        card.style.transform = "translateY(0)";
                        card.style.boxShadow = "2px 2px 12px rgba(0,0,0,0.1)";
                    });
                });
            })
            .catch(error => console.error("API 호출 중 오류 발생:", error));
    }

    // 페이지 로딩 시 사용자의 위치를 가져오기 위해 함수 호출
    getUserLocation();
</script>