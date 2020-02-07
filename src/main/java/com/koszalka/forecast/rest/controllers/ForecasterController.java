package com.koszalka.forecast.rest.controllers;

import com.koszalka.forecast.bo.CityBO;
import com.koszalka.forecast.persistence.dto.CityDTO;
import com.koszalka.forecast.persistence.entities.CityEntity;
import com.koszalka.forecast.rest.api.CityAPI;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForecasterController implements CityAPI {

    private final CityBO cityBO;

    @Autowired
    public ForecasterController(CityBO cityBO) {
        this.cityBO = cityBO;
    }

    @Override
    public ResponseEntity<List<CityEntity>> getCities(HttpServletResponse response) {
        List<CityEntity> res = cityBO.getCities();
        return new ResponseEntity<List<CityEntity>>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CityEntity> getCity(HttpServletResponse response, String city) {
        CityEntity res = cityBO.getCityByName(city);
        return new ResponseEntity<CityEntity>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CityDTO> postCity(CityDTO dto)  {
        // check if the city is already persisted at the DB
        // if so will return a 409 (conflict)
        if (cityBO.getCityByName(dto.getCity()) != null) {
            return new ResponseEntity<CityDTO>(HttpStatus.CONFLICT);
        }
        cityBO.saveOne(dto);
        return new ResponseEntity<CityDTO>(HttpStatus.CREATED);

    }

}
