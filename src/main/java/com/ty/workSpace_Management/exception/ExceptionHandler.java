package com.ty.workSpace_Management.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.workSpace_Management.entity.util.ResponseStructure;



@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> list = ex.getAllErrors();
		HashMap<String,String> hashmap = new HashMap<>();
		for(ObjectError error:list) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			hashmap.put(fieldName, message);
		}
		
		return new ResponseEntity<Object>(hashmap,HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<ResponseStructure<String>> ClientBookingNotFound(ClientBookingNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client booking not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> ClientNotFound(ClientNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client  not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> ClientNotFound(ClientNotFoundByEmail ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client not found by email");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> ClientPasswordIncorrect(ClientPasswordIncorrect ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client password incorrect");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> EmployeeNotFound(EmployeeNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("employee not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> EmployeePasswordWrong(EmployeePasswordWrong ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("employee password wrong");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> IdInvalidForEntity(IdInvalidForEntity ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("id invalid for any type entity");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> AddressNotFound(AddressNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("address not found for given id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	

}
