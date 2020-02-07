package com.koszalka.shortener.rest.api;

import com.koszalka.shortener.persistence.dto.CityDTO;
import javax.servlet.http.HttpServletResponse;

import com.koszalka.shortener.persistence.entities.CityEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "/v1")
public interface CityAPI {

    @RequestMapping(path = "/{city}",method = RequestMethod.GET)
    ResponseEntity<CityEntity> getCity(HttpServletResponse response, @PathVariable("city") String urlString);

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    ResponseEntity<CityDTO> postCity(@RequestBody CityDTO data);

}

