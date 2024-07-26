package com.backend24.howtrip.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

    @RequestMapping("/maps.do")
    public String showMap() {
        return "maps";
    }
}
