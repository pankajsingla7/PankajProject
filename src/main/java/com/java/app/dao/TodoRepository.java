package com.java.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface TodoRepository extends Repository<Todo, String> {

	void delete(Todo deleted);
	 
    List<Todo> findAll();
 
    Optional<Todo> findById(String id);
 
    Todo save(Todo saved);
	
}
