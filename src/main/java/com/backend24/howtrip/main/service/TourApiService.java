package com.backend24.howtrip.main.service;

import com.backend24.howtrip.main.dto.TourApiDto;
import com.backend24.howtrip.main.dto.TourApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TourApiService {

    public static final String API_KEY = "g7zo%2B%2BOOdEI5niJTnCjpDjZ5%2BBmi10b1nxZ3n96a7oJeYd%2BwsdXSYSCsIYDNoPKaUMp%2BrdQD3Zq03DxnOCKO8w%3D%3D";
    

    public static final String TOUR_API_BASE_URL = "http://apis.data.go.kr/B551011/KorService1/locationBasedList1";

    public TourApiDto getTourismInfoByLocation(double lat, double lon) {
        RestTemplate restTemplate = new RestTemplate();

        HttpClient httpClient = HttpClient.newHttpClient();
        URI uri = null;
        try {
            uri = new URI(TOUR_API_BASE_URL +
                    "?serviceKey=" + API_KEY +
                    "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A" +
                    "&mapX=" + lon + "&mapY=" + lat + "&radius=1000&listYN=Y");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JAXBContext jaxbContext = JAXBContext.newInstance(TourApiResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            TourApiResponse tourApiResponse = (TourApiResponse) unmarshaller.unmarshal(new StringReader(response.body()));
            TourApiDto tourApiDto = new TourApiDto();
            tourApiDto.tourItems = tourApiResponse
                    .getBody()
                    .getItems()
                    .getItemList()
                    .stream()
                    .map(it -> {
                        TourApiDto.TourItem tourItem = new TourApiDto.TourItem();
                        tourItem.name = it.getTitle();
                        tourItem.address = it.getAddr1();
                        tourItem.imageUrl = it.getFirstimage();
                        return tourItem;
                    })
                    .filter(dto -> !dto.imageUrl.isBlank())
                    .collect(Collectors.toList());
            return tourApiDto;
        } catch (IOException | InterruptedException | JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
