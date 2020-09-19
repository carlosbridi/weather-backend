package com.bridi.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Wind {

	@JsonProperty
	private Double speed;
	@JsonProperty
	private Double deg;
	
}
