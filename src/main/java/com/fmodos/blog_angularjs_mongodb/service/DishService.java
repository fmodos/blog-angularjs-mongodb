package com.fmodos.blog_angularjs_mongodb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fmodos.blog_angularjs_mongodb.domain.CommentVO;
import com.fmodos.blog_angularjs_mongodb.domain.Dish;
import com.fmodos.blog_angularjs_mongodb.domain.DishNameVO;
import com.fmodos.blog_angularjs_mongodb.domain.DishVO;
import com.fmodos.blog_angularjs_mongodb.repository.DishRepository;

@Service
public class DishService {

	@Autowired
	DishRepository dishRepository;

	public void insert(DishVO blog) {
		Dish blogPost = new Dish(blog.getName(), blog.getDescription(), blog.getAllTags(), Double.parseDouble(blog.getPrice()));
		dishRepository.insert(blogPost);
	}

	public List<DishNameVO> getAllResumed() {
		final List<Dish> listDish = dishRepository.findAll();
		return converToDishNameVO(listDish);
	}

	private List<DishNameVO> converToDishNameVO(final List<Dish> listDish) {
		List<DishNameVO> ret = new ArrayList<DishNameVO>();
		for (Dish blogPost : listDish) {
			ret.add(new DishNameVO(blogPost));
		}
		return ret;
	}

	public List<DishNameVO> findByName(String name) {
		return converToDishNameVO(dishRepository.findByNameLike(name));
	}

	public List<DishNameVO> findByNicknameInComment(String name) {
		return converToDishNameVO(dishRepository.findByNicknameInComment(name));
	}

	public List<DishNameVO> findByIngredients(String name) {
		return null;
	}

	public Dish findById(String id) {
		return dishRepository.findOne(id);
	}

	public void addComment(CommentVO comment) {
		Dish blogPost = dishRepository.findOne(comment.getDishId());
		if (blogPost == null) {
			throw new IllegalArgumentException(String.format("Dish with id '%s' not found", comment.getDishId()));
		}
		blogPost.addComment(comment);
		dishRepository.save(blogPost);
	}

	public List<DishNameVO> findByPrice(String name) {
		return converToDishNameVO(dishRepository.findByPrice(Double.parseDouble(name)));
	}

}
