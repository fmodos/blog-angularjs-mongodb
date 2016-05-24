package com.fmodos.blog_angularjs_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fmodos.blog_angularjs_mongodb.domain.Dish;

public interface DishRepository extends MongoRepository<Dish, String>, ICustomDishRepository {

	public List<Dish> findByNameLike(String name);

	public List<Dish> findByPrice(double parseDouble);

}
