package com.bridi.weather.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridi.weather.model.City;

@Repository
public interface CityRepository extends MongoRepository<City, Long>, CityRepositoryCustom {

}
