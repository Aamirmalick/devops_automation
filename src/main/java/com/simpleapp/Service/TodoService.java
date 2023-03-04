package com.simpleapp.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.simpleapp.payload.request.todoDto;
@Component
public interface TodoService {

	public ResponseEntity<?> AddTodo(todoDto todoDto);
	public ResponseEntity<?> EditTodo(String todoId,todoDto todoDto);
	public ResponseEntity<?> ListTodo();
	public ResponseEntity<?> DeleteTodo(String TodoId);
	public ResponseEntity<?> SearchTodo(String TodoId);
}
