package com.fmodos.blog_angularjs_mongodb.domain;

import java.util.Date;

public class Comment {

	private String id;

	private String nickname;

	private String text;

	private Date dateCreated;

	Comment(String nickname, String text) {
		this.nickname = nickname;
		this.text = text;
		this.dateCreated = new Date();
	}

	public String getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public String getText() {
		return text;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

}
