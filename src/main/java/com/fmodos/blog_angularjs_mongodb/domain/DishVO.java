package com.fmodos.blog_angularjs_mongodb.domain;

import java.io.Serializable;

public class DishVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String price;

	private String description;

	private String tags;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String getPrice() {
		return price;
	}

	public String getTags() {
		return tags;
	}

	public String[] getAllTags() {
		return tags != null ? tags.split(",") : null;
	}

}
