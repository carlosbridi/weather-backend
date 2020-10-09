package com.bridi.weather.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bridi.weather.model.City;
import com.bridi.weather.model.WeatherInfo;
import com.bridi.weather.repository.CityRepository;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

	@InjectMocks
	private CityService cityService;
	
	@Mock
	private OpenWeatherService openWeatherService;
	
	@Mock
	private CityRepository cityRepository;
	
	@Rule
	public ExpectedException expectException = ExpectedException.none();
	
	@Test
	public void shouldInsertNewCity() {
		City c = new City();
		c.setName("Iowa");
		
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setCity(c);
			
		Mockito.when(cityRepository.findByName(Mockito.anyString())).thenReturn(null);
		Mockito.when(openWeatherService.getCityInfo(Mockito.any(), Mockito.any())).thenReturn(weatherInfo);
		
		cityService.save(c);
		
		Mockito.verify(cityRepository, Mockito.times(1)).save(c);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldFoundCityInDB() {
		City cityIowaDB = new City();
		cityIowaDB.setName("Iowa");
		
		City cityIowa = new City();
		cityIowa.setName("Iowa");
		
		Mockito.when(cityRepository.findByName(Mockito.any())).thenReturn(cityIowaDB);
		
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setCity(cityIowa);
		
		cityService.save(cityIowa);
		Mockito.verify(cityRepository, Mockito.times(0)).save(cityIowa);
	}
	
	@Test
	public void listCity() {
		
		City cityIowa = new City();
		cityIowa.setName("Iowa");
		
		City cityArizona = new City();
		cityArizona.setName("Arizona");
		
		List<City> cityList = Arrays.asList(cityIowa, cityArizona);
		
		Mockito.when(cityRepository.findAll()).thenReturn(cityList);
		
		List<City> findAllDbCities = cityRepository.findAll();
		
		assertEquals(findAllDbCities.size(), cityList.size());
		
	}
}
