package com.java.app.dao;

import java.util.List;
import java.util.Optional;

import com.java.app.dao.Todo;

public interface TodoRepository {

	void delete(Todo deleted);
	 
    List<Todo> findAll();
 
    Optional<Todo> findOne(String id);
 
    Todo save(Todo saved);
	
}
