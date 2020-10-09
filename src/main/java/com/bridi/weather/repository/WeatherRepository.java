package com.bridi.weather.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridi.weather.model.WeatherInfo;

@Repository
public interface WeatherRepository extends MongoRepository<WeatherInfo, Long> {
		
}
