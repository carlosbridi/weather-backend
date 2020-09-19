package com.bridi.weather.service;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bridi.weather.exception.ServiceException;
import com.bridi.weather.model.City;
import com.bridi.weather.repository.CityRepository;

@Service
public class CityService {

	@Inject
	private CityRepository cityRepository;
	
	@Inject
	private OpenWeatherService openWeatherService;
	
	public List<City> listCity(){
		return cityRepository.findAll();
	}
	
	public City save(City city) {
		City findByName = cityRepository.findByName(city.getName());
		if (Objects.nonNull(findByName))
			throw new ServiceException("Cidade já cadastrada");
		else {
			City cityCreated = openWeatherService.getWeatherInfo(city.getName(), city.getCountry()).getCity();
			return cityRepository.save(cityCreated);
		}		
	}	
}
