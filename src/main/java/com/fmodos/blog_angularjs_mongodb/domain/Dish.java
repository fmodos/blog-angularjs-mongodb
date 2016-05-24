package com.fmodos.blog_angularjs_mongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Dish implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	
	private Double price;

	private String description;

	private String[] ingredients;

	private Date dateCreated;

	private List<Comment> comments = new ArrayList<Comment>();

	public Dish() {

	}

	public Dish(String title, String description, String[] tags, Double price) {
		this.name = title;
		this.description = description;
		this.ingredients = tags;
		this.dateCreated = new Date();
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}

	public boolean removeCommentById(String id) {
		for (Iterator<Comment> iterator = comments.iterator(); iterator.hasNext();) {
			Comment type = (Comment) iterator.next();
			if (type.getId().equals(id)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public void addComment(CommentVO comment) {
		if (!this.id.equals(comment.getDishId())) {
			throw new IllegalArgumentException("This comment doesn't belong to this Blog");
		}
		comments.add(new Comment(comment.getNickname(), comment.getText()));
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

}
