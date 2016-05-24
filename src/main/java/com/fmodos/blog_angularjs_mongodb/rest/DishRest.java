package com.fmodos.blog_angularjs_mongodb.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmodos.blog_angularjs_mongodb.domain.CommentVO;
import com.fmodos.blog_angularjs_mongodb.domain.Dish;
import com.fmodos.blog_angularjs_mongodb.domain.DishNameVO;
import com.fmodos.blog_angularjs_mongodb.domain.DishVO;
import com.fmodos.blog_angularjs_mongodb.service.DishService;

@Path("dish")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class DishRest {

	@Autowired
	DishService dishService;

	@POST
	public void insert(DishVO blogPostVO) {
		dishService.insert(blogPostVO);
	}

	@POST
	@Path("/add-comment")
	public void addComment(CommentVO commentVO) {
		dishService.addComment(commentVO);
	}

	@GET
	public List<DishNameVO> getAll() {
		return dishService.getAllResumed();
	}

	@GET
	@Path("{id}")
	public Dish getById(@PathParam("id") String id) {
		return dishService.findById(id);
	}

	@GET
	@Path("/byName/{name}")
	public List<DishNameVO> getByName(@PathParam("name") String name) {
		return dishService.findByName(name);
	}

	@GET
	@Path("/byNicknameInComment/{name}")
	public List<DishNameVO> getByNicknameInComment(@PathParam("name") String name) {
		return dishService.findByNicknameInComment(name);
	}

	@GET
	@Path("/byIngredients/{name}")
	public List<DishNameVO> getByIngredients(@PathParam("name") String name) {
		return dishService.findByIngredients(name);
	}
	
	@GET
	@Path("/byPrice/{name}")
	public List<DishNameVO> getByPrice(@PathParam("name") String name) {
		return dishService.findByPrice(name);
	}

}
