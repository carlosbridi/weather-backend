package com.bridi.weather.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bridi.weather.model.City;
import com.bridi.weather.service.CityService;
import com.google.gson.Gson;

@RunWith(MockitoJUnitRunner.class)
public class CityControllerTest {
	
	@InjectMocks
	public CityController cityController;
	
	@Mock
	public CityService cityService;
	
	@Test
	public void shouldRegisterCity() {
		City newCity = new City();
		newCity.setName("Iowa");
		newCity.setCountry("US");
		
		Mockito.when(cityService.save(Mockito.any())).thenReturn(newCity);
		
		String payload = new Gson().toJson(newCity).toString();
		
		cityController.registerCity(payload);
	}
}
