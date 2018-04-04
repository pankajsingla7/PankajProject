package com.java.app.service;

import java.util.List;

import com.java.app.DTO.TodoDTO;

public interface TodoService {

	 TodoDTO create(TodoDTO todo);
	 
	    TodoDTO delete(String id) ;
	 
	    List<TodoDTO> findAll();
	 
	    TodoDTO findById(String id);
	 
	    TodoDTO update(TodoDTO todo);
}
