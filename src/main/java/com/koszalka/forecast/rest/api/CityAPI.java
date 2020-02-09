package com.koszalka.forecast.rest.api;

import com.koszalka.forecast.persistence.dto.CityDTO;
import javax.servlet.http.HttpServletResponse;

import com.koszalka.forecast.persistence.entities.CityEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(path = "/v1")
public interface CityAPI {

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    ResponseEntity<CityDTO> postCity(@RequestBody CityDTO data);

    @RequestMapping(path = "/cities", method = RequestMethod.GET)
    ResponseEntity<List<CityEntity>> getCities(HttpServletResponse response);

    @RequestMapping(path = "/delete/{city}", method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteCity(HttpServletResponse response, @PathVariable("city") String city);

    @RequestMapping(path = "/city/{city}",method = RequestMethod.GET)
    ResponseEntity<CityEntity> getCity(HttpServletResponse response, @PathVariable("city") String city);

}

