<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행 지도</title>
    <style>
        /* 페이지 전체를 차지하도록 설정 */
        html, body {
            height: 100%;
            margin: 0;
        }
        #map {
            width: 100%;
            height: 100%;
        }
        .infoWindow {
            width: 200px;
            padding: 10px;
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
    </style>
    <script src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=z5bc4u4u65"></script>
</head>
<body>
    <div id="map"></div>
    <script>
        const mapOptions = {
            center: new naver.maps.LatLng(37.5665, 126.978),
            zoom: 7 // 줌 레벨을 낮춰 더 많은 지역을 볼 수 있도록 설정
        };
        const map = new naver.maps.Map('map', mapOptions);

        async function fetchTouristSpots(pageNo = 1) {
            const apiKey = 'g7zo++OOdEI5niJTnCjpDjZ5+Bmi10b1nxZ3n96a7oJeYd+wsdXSYSCsIYDNoPKaUMp+rdQD3Zq03DxnOCKO8w==';
            const url = `https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=g7zo%2B%2BOOdEI5niJTnCjpDjZ5%2BBmi10b1nxZ3n96a7oJeYd%2BwsdXSYSCsIYDNoPKaUMp%2BrdQD3Zq03DxnOCKO8w%3D%3D&numOfRows=100&pageNo=${pageNo}&MobileOS=ETC&MobileApp=AppTest&arrange=A&contentTypeId=12`;

            try {
                const response = await fetch(url);
                const text = await response.text(); // XML 응답을 텍스트로 받음
                const parser = new DOMParser();
                const xmlDoc = parser.parseFromString(text, "text/xml"); // XML 문서로 파싱

                const items = xmlDoc.getElementsByTagName('item');
                if (items.length === 0) {
                    return; // 더 이상 데이터가 없으면 종료
                }

                Array.from(items).forEach(item => {
                    const title = item.getElementsByTagName('title')[0].textContent;
                    const mapx = parseFloat(item.getElementsByTagName('mapx')[0].textContent);
                    const mapy = parseFloat(item.getElementsByTagName('mapy')[0].textContent);
                    const addr1 = item.getElementsByTagName('addr1')[0].textContent;

                    if (isNaN(mapx) || isNaN(mapy)) {
                        console.error(`Invalid coordinates for ${title}`);
                        return;
                    }

                    const position = new naver.maps.LatLng(mapy, mapx);
                    const marker = new naver.maps.Marker({
                        position: position,
                        map: map,
                        title: title
                    });

                    const infoWindow = new naver.maps.InfoWindow({
                        content: `<div class="infoWindow"><h4>${title}</h4><p>${addr1}</p></div>`,
                        backgroundColor: '#ffffff',
                        borderColor: '#dddddd',
                        borderWidth: 1
                    });

                    naver.maps.Event.addListener(marker, 'click', function() {
                        infoWindow.open(map, marker);
                    });
                });

                // 다음 페이지 데이터 요청
                fetchTouristSpots(pageNo + 1);
            } catch (error) {
                console.error('관광지 정보를 가져오는 데 실패했습니다.', error);
            }
        }

        fetchTouristSpots(1); // 시작 페이지 번호
    </script>
</body>
</html>
