package com.backend24.howtrip.trip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class TripMapController {
	private static final Logger logger = LoggerFactory.getLogger(TripMapController.class);
	
	//@RequestMapping(value = "/trip/tripMap.do", method = RequestMethod.GET)
	public void tripMapPageGet() {
		logger.info("여행 지도 페이지 진입");
	}

}
