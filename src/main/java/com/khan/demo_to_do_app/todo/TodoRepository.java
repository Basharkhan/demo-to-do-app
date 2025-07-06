package com.khan.demo_to_do_app.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	List<Todo> findByusername(String username);
}
