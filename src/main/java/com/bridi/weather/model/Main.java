package com.bridi.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Main {

	@JsonProperty
	private Double temp;
	@JsonProperty
	private Double pressure;
	@JsonProperty
	private Double humidity;
	@JsonProperty
	private Double temp_max;
	@JsonProperty
	private Double temp_min;
	@JsonProperty
	private Double feels_like;
	
}
