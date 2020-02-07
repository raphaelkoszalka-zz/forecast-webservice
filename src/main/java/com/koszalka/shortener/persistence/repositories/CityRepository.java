package com.koszalka.shortener.persistence.repositories;

import com.koszalka.shortener.persistence.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    @Query("SELECT city"
        + " FROM CityEntity as city"
        + " WHERE city.city = :city")
    CityEntity getCityByName(@Param("city") String city);


}
