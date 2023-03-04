package com.simpleapp.ServiceImpl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simpleapp.Model.Todo;
import com.simpleapp.Repository.TodoRepository;
import com.simpleapp.Service.TodoService;
import com.simpleapp.payload.request.todoDto;
import com.simpleapp.payload.response.MessageResponse;
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;
	@Autowired
	Environment env;
	
	@Override
	public ResponseEntity<?> AddTodo(todoDto todoDto) {
		try {
			Todo todo=Todo.builder()
					.title(todoDto.getTitle())
					.Content(todoDto.getContent())
					.CreatedDate(new Date())
					.build();
			todo=todoRepository.save(todo);
			
	return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("add.todo.success"), todo));
			
			
		}catch (Exception e) {
		
	return ResponseEntity.ok(new MessageResponse(HttpStatus.PARTIAL_CONTENT.value(),e.getLocalizedMessage()));
		}
	}

	@Override
	public ResponseEntity<?> EditTodo(String todoId, todoDto todoDto) {
		try {
			Todo todo=todoRepository.findById(todoId).get();
			Todo todo2=Todo.builder()
					.id(todo.getId())
					.title(todoDto.getTitle())
					.Content(todoDto.getContent())
					.build();
			todo2=todoRepository.save(todo2);
			return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("update.todo.success"), todo2));

		}catch (Exception e) {
			return ResponseEntity.ok(new MessageResponse(HttpStatus.PARTIAL_CONTENT.value(),e.getLocalizedMessage()));
		}
	}

	@Override
	public ResponseEntity<?> ListTodo() {
		
		try
		{
			List<Todo> todo=todoRepository.findAll();
			return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("list.todo.success"), todo));			
		}catch (Exception e) {
			return ResponseEntity.ok(new MessageResponse(HttpStatus.PARTIAL_CONTENT.value(),e.getLocalizedMessage()));
		}
	}

	@Override
	public ResponseEntity<?> DeleteTodo(String TodoId) {
try {
	todoRepository.deleteById(TodoId);
	return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("delete.todo.success")));			
}catch (Exception e) {
	return ResponseEntity.ok(new MessageResponse(HttpStatus.PARTIAL_CONTENT.value(),e.getLocalizedMessage()));

}
	
	}

	@Override
	public ResponseEntity<?> SearchTodo(String TodoId) {
		try {
			Todo todo=todoRepository.findById(TodoId).get();
			return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), env.getProperty("search.todo.success"), todo));			
		}catch (Exception e) {
			return ResponseEntity.ok(new MessageResponse(HttpStatus.PARTIAL_CONTENT.value(),e.getLocalizedMessage()));
		}
		
	
	}

}
