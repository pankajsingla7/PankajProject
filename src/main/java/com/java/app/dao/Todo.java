package com.java.app.dao;

import org.springframework.data.annotation.Id;

public class Todo {


	@Id
    private String id;
 
    private String description;
 
    private String title;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(String title2, String description2) {
		// TODO Auto-generated method stub
		
	}
	
}
