package com.koszalka.shortener.bo;

import com.koszalka.shortener.persistence.dto.CityDTO;
import com.koszalka.shortener.persistence.entities.CityEntity;
import com.koszalka.shortener.persistence.repositories.CityRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

//    private Long verifyIfHashAlreadyExist(String hash, Long expirationDate) {
//        return cityRepository.verifyIfHashAlreadyExist(hash, expirationDate);
//    }

    public ResponseEntity<CityDTO> send301Redirect(HttpServletResponse response, String newUrl) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", newUrl);
        response.setHeader("Connection", "close");
        return new ResponseEntity<CityDTO>(HttpStatus.MOVED_PERMANENTLY);
    }
}
