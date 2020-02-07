package com.koszalka.shortener.rest.controllers;

import com.koszalka.shortener.bo.CityBO;
import com.koszalka.shortener.persistence.dto.CityDTO;
import com.koszalka.shortener.persistence.entities.CityEntity;
import com.koszalka.shortener.rest.api.CityAPI;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecasterController implements CityAPI {

    private final CityBO cityBO;

    @Autowired
    public ForecasterController(CityBO cityBO) {
        this.cityBO = cityBO;
    }

    @Override
    public ResponseEntity<CityEntity> getCity(HttpServletResponse response, String city) {
        CityEntity res = cityBO.getCityByName(city);
        return new ResponseEntity<CityEntity>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CityDTO> postCity(CityDTO dto)  {
        // check if the city is already persisted at the DB
        // if so will return a 409
        if (cityBO.getCityByName(dto.getCity()) != null) {
            return new ResponseEntity<CityDTO>(HttpStatus.CONFLICT);
        }
        cityBO.saveOne(dto);
        return new ResponseEntity<CityDTO>(HttpStatus.CREATED);

    }

}
