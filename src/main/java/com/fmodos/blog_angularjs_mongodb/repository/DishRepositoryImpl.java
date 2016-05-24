package com.fmodos.blog_angularjs_mongodb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fmodos.blog_angularjs_mongodb.domain.Dish;

public class DishRepositoryImpl implements ICustomDishRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Dish> findByNicknameInComment(String tag) {
		Query query = new Query();
		query.addCriteria(Criteria.where("comments").elemMatch(Criteria.where("nickname").is(tag)));
		return mongoTemplate.find(query, Dish.class);
	}

}
