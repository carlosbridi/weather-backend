package com.bridi.weather.repository;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bridi.weather.model.City;

public class CityRepositoryCustomImpl implements CityRepositoryCustom {

	@Inject
    MongoTemplate mongoTemplate;
	
	@Override
	public City findByName(String name) {
		Query q = new org.springframework.data.mongodb.core.query.Query();
		q.addCriteria(Criteria.where("name").is(name));
		
		return mongoTemplate.findOne(q, City.class, "city");
	}	
}