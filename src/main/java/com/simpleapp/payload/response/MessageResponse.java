package com.simpleapp.payload.response;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {

	private int Status;
	private String Message;
	private Object Response;
	public MessageResponse(int status, String message) {
		super();
		Status = status;
		Message = message;
	}
	
}
