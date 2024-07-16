package com.backend24.howtrip.main.dto;

import java.util.List;

public class TourApiDto {
    public List<TourItem> tourItems;

    public static class TourItem {
        public String name;
        public String address;
        public String imageUrl;

        @Override
        public String toString() {
            return "TourItem{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TourApiDto{" +
                "tourItems=" + tourItems +
                '}';
    }
}
