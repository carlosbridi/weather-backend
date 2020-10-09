package com.bridi.weather.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridi.weather.model.WeatherInfo;

@Service
public class OpenWeatherService {

	private static final String METRIC = "metric";
	private static final String PT_BR = "pt_br";
	private static final String DEFAULT_URI_API = "https://api.openweathermap.org/data/2.5/forecast";
	private static final String API_KEY = "7fa9bf0297e3388e60c61a5e3b8abec0";
	
	/**
	 * Get city info to register on DB
	 * @param city City name
	 * @return
	 */
	public WeatherInfo getCityInfo(String city, String country) {
		RestTemplate restTemplate = new RestTemplate();
		Client newClient = ClientBuilder.newClient();
		WeatherInfo response = restTemplate.getForObject(newClient
				.target(DEFAULT_URI_API)
				.queryParam("q", city)
				.queryParam("appid", API_KEY)
				.queryParam("lang", PT_BR)
				.queryParam("units", METRIC)
				.getUriBuilder().toString(), WeatherInfo.class);
				
		return response;
	}
	
	/**
	 * Get weather info from id of city
	 * @param cityId City id
	 * @return Weather info
	 */
	public WeatherInfo getWeatherById(String cityId) {
		RestTemplate restTemplate = new RestTemplate();
		Client newClient = ClientBuilder.newClient();
		WeatherInfo response = restTemplate.getForObject(newClient
				.target(DEFAULT_URI_API)
				.queryParam("id", cityId)
				.queryParam("appid", API_KEY)
				.queryParam("lang", PT_BR)
				.queryParam("units", METRIC)
				.getUriBuilder().toString(), WeatherInfo.class);
			
	
		return response;
	}

}