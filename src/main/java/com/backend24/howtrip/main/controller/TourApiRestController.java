package com.backend24.howtrip.main.controller;

import com.backend24.howtrip.main.dto.TourApiDto;
import com.backend24.howtrip.main.service.TourApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourApiRestController {

    @Autowired
    private TourApiService tourApiService;

    @RequestMapping(value = "/location-based-list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TourApiDto locationBasedList(@RequestParam double lat, @RequestParam double lon) {
        TourApiDto response = tourApiService.getTourismInfoByLocation(lat, lon);
        // 셔플
        List<TourApiDto.TourItem> list = new ArrayList<>(response.tourItems);
        Collections.shuffle(list);
        response.tourItems = list.subList(0, Math.min(3, list.size()));
        System.out.println(response);
        return response;
    }


}
