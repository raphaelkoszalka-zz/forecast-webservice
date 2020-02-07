package com.koszalka.shortener.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
// import lombok.Getter;
// import lombok.Setter;

@Entity
@Table(name = "city", schema = "public")
// @Getter
// @Setter
public class CityEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "short_sequence")
    @SequenceGenerator(name = "short_sequence", sequenceName = "short_sequence", allocationSize = 1, initialValue = 1, schema = "public")
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "lat", nullable = false)
    private String lat;

    @Column(name = "lng", nullable = false)
    private String lng;

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getLat() { return lat; }
    public void setLat(String lat) { this.lat = lat; }

    public String getLng() { return lng; }
    public void setLng(String lng) { this.lng = lng; }

}
