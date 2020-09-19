package com.bridi.weather.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridi.weather.model.WeatherInfo;
import com.bridi.weather.service.OpenWeatherService;

@RestController
public class FindWeatherController {

	@Inject
	private OpenWeatherService openService;	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getWeatherCity")
	@ResponseBody
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public WeatherInfo getStringMessage(@QueryParam(value = "cityId") String cityId) {
		WeatherInfo weatherInfoCity = openService.getWeatherById(cityId);
		return weatherInfoCity;
	}
}
