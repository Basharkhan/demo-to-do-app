package com.khan.demo_to_do_app.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "khan", "Learn Aws", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "khan", "Learn Docker", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "khan", "Learn Cloud", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "khan", "Learn Java", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "khan", "Learn Python", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addTodo(
			String username, 
			String description, 
			LocalDate targetDate, 
			boolean done
		) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	public Todo findById(int id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
