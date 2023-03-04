package com.simpleapp.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapp.ServiceImpl.TodoServiceImpl;
import com.simpleapp.payload.request.todoDto;
@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	TodoServiceImpl todoServiceImpl;
	@PostMapping("/add")
	public ResponseEntity<?> CreateTodo(@RequestBody todoDto todoDto)
	{
		return todoServiceImpl.AddTodo(todoDto);
	}
	@GetMapping("/list")
	public ResponseEntity<?> ListTodo()
	{
		return todoServiceImpl.ListTodo();
	}
	@PutMapping("/update/{todoId}")
	public ResponseEntity<?> UpdateTodo(@PathVariable String todoId,@RequestBody todoDto todoDto)
	{
		return todoServiceImpl.EditTodo(todoId, todoDto);
    }
	@DeleteMapping("/delete/{todoId}")
	public ResponseEntity<?> DeleteTodo(@PathVariable String todoId)
	{
		return todoServiceImpl.DeleteTodo(todoId);
	}
	@GetMapping("/search/{todoId}")
	public ResponseEntity<?> SearchTodo(@PathVariable String todoId)
	{
		return todoServiceImpl.SearchTodo(todoId);
	}

}