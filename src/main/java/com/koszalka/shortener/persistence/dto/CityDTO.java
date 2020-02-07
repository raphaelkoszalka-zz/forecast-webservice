package com.koszalka.shortener.persistence.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    private String city;
    private String lat;
    private String lng;

    public CityDTO(String city, String lat, String lng) {
        this.city = city;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getLat() { return lat; }
    public void setLat(String lat) { this.lat = lat; }

    public String getLng() { return lng; }
    public void setLng(String lng) { this.lng = lng; }



}
