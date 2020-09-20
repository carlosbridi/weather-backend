package com.bridi.weather.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class List {

	@JsonProperty
	private Double dt;
	@JsonProperty
	private Main main;
	@JsonProperty
	private java.util.List<Weather> weather;
	@JsonProperty
	private String dt_txt;
	
	private Date date;
	
}
