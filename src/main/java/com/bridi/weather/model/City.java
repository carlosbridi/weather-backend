package com.bridi.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class City {

	@JsonProperty
	private Long id;
	@JsonProperty
	private String name;
	@JsonProperty
	private Coord coord;
	@JsonProperty
	private String country;
	@JsonProperty
	private Double population;
	@JsonProperty
	private Double timezone;
	
}
