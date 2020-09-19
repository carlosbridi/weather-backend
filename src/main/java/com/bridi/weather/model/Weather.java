package com.bridi.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Weather {

	@JsonProperty
	private Integer id;
	@JsonProperty
    private String main;
	@JsonProperty
    private String description;
	@JsonProperty
    private String icon;
	
    	
}
