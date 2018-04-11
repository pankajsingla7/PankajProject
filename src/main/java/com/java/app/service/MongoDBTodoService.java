package com.java.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.app.DTO.TodoDTO;
import com.java.app.appException.TodoNotFoundException;
import com.java.app.dao.Todo;
import com.java.app.dao.TodoRepository;

@Service
public class MongoDBTodoService implements TodoService {
	private final TodoRepository repository;
	 
    @Autowired
    MongoDBTodoService(TodoRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public TodoDTO create(TodoDTO todo) {
        Todo persisted = new Todo();
        persisted.setName(todo.getName());
        persisted.setStatus(todo.isStatus());
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public TodoDTO delete(String id) throws TodoNotFoundException {
        Todo deleted = findTodoById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<TodoDTO> findAll() {
        List<Todo> todoEntries = repository.findAll();
        return convertToDTOs(todoEntries);
    }
 
    private List<TodoDTO> convertToDTOs(List<Todo> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
 
    @Override
    public TodoDTO findById(String id) {
        Todo found = findTodoById(id);
        return convertToDTO(found);
    }
 
    @Override
    public TodoDTO update(TodoDTO todo) {
        Todo updated = findTodoById(todo.getId());
        updated.update(todo.isStatus(), todo.getName());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Todo findTodoById(String id) {
    	
//        Todo result = repository.findById(id);
//        return result;
    	
        Optional<Todo> result = repository.findById(id);
        return result.orElseThrow(() -> new TodoNotFoundException(id));
 
    }
 
    private TodoDTO convertToDTO(Todo model) {
        TodoDTO dto = new TodoDTO();
 
        dto.setId(model.getId());
        dto.setStatus(model.getStatus());
        dto.setName(model.getName());
 
        return dto;
    }
	
	
}
