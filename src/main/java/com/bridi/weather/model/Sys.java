package com.bridi.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Sys {

	@JsonProperty
	private Long type;
	@JsonProperty
	private int id;
	@JsonProperty
	private Double message;
	@JsonProperty
	private String country;
	@JsonProperty
	private Double sunrise;
	@JsonProperty
	private Double sunset;
	
}
