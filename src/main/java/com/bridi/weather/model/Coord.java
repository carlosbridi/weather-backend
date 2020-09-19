package com.bridi.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Coord {

	@JsonProperty
	private Double lon;
	@JsonProperty
    private Double lat;

}