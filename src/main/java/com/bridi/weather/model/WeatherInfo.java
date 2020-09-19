package com.bridi.weather.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(collection = "weatherinfo")
public class WeatherInfo {

	@JsonProperty
	private City city;
	@JsonProperty
	private int cod;
	@JsonProperty
	private Coord coord;
	
	@JsonProperty
	private List<com.bridi.weather.model.List> list;
	
	@JsonProperty
	private String base;
	@JsonProperty
	private Double visibility;
	@JsonProperty
	private Double dt;
	
}
