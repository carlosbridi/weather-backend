package com.bridi.weather.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.bridi.weather.exception.ServiceException;
import com.bridi.weather.model.City;
import com.bridi.weather.service.CityService;
import com.google.gson.Gson;

@RestController
public class CityController {

	@Inject
	private CityService cityService;

	@RequestMapping(method = RequestMethod.POST, value = "/registerCity")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public City registerCity(@RequestBody String data) {
		try {
			City city = new Gson().fromJson(data, City.class);
			return cityService.save(city);
		} catch (HttpClientErrorException e) {
			throw new ServiceException("Cidade não encontrada");
		} catch (Exception e) {
			throw new ServiceException("Erro ao carregar dados do payload");
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listCity")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public List<City> listCity() {
		return cityService.listCity();
	}

}
