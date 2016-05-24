package com.fmodos.blog_angularjs_mongodb.repository;

import java.util.List;

import com.fmodos.blog_angularjs_mongodb.domain.Dish;

public interface ICustomDishRepository {

	List<Dish> findByNicknameInComment(String tag);

}
