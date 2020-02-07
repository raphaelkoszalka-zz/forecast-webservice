package com.koszalka.forecast.persistence.repositories;

import com.koszalka.forecast.persistence.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    @Query("SELECT city FROM CityEntity as city WHERE city.city = :city")
    CityEntity getCityByName(@Param("city") String city);

    @Query("SELECT city FROM CityEntity as city")
    List<CityEntity> getCities();

}
