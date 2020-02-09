package com.koszalka.forecast.bo;

import com.koszalka.forecast.persistence.dto.CityDTO;
import com.koszalka.forecast.persistence.entities.CityEntity;
import com.koszalka.forecast.persistence.repositories.CityRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityBO {


    private final CityRepository cityRepository;

    @Autowired
    public CityBO(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void saveOne(CityDTO cityDTO)  {
        CityEntity entity = new CityEntity();
        entity.setCity(cityDTO.getCity());
        entity.setLat(cityDTO.getLat());
        entity.setLng(cityDTO.getLng());
        cityRepository.save(entity);
    }

    public CityEntity getCityByName(String city) {
        return cityRepository.getCityByName(city);
    }

    public void delete(String city) {
        CityEntity c = getCityByName(city);
        cityRepository.delete(c);
    }

    public List<CityEntity> getCities() {
        return cityRepository.findAll();
    }

}
