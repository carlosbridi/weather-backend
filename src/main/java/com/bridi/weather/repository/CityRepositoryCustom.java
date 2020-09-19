package com.bridi.weather.repository;

import com.bridi.weather.model.City;

public interface CityRepositoryCustom {

	City findByName(String name);
	
}
