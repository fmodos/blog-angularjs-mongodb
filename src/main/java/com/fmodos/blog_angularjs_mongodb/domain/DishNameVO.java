package com.fmodos.blog_angularjs_mongodb.domain;

import java.util.Date;

public class DishNameVO {

	private String id;

	private String name;

	private Date dateCreated;

	public DishNameVO(Dish dish) {
		this.id = dish.getId();
		this.name = dish.getName();
		this.dateCreated = dish.getDateCreated();

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

}
