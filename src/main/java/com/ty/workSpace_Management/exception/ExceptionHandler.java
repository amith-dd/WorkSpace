package com.ty.workSpace_Management.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.workSpace_Management.entity.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ClientBookingNotFound(ClientBookingNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client booking not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ClientNotFound(ClientNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client  not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ClientNotFound(ClientNotFoundByEmail ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client not found by email");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ClientPasswordIncorrect(ClientPasswordIncorrect ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("client password incorrect");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> EmployeeNotFound(EmployeeNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("employee not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> EmployeePasswordWrong(EmployeePasswordWrong ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("employee password wrong");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> IdInvalidForEntity(IdInvalidForEntity ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("id invalid for any type entity");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AddressNotFound(AddressNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("address not found for given id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundByAdmin.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(IdNotFoundByAdmin exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Id is not found for admin ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementFoundByAdminException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByAdminException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("element is not found for admin ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(LoginByAdminException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(LoginByAdminException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("pls provide proper pwd  for login admin");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map = new HashMap<String, String>();
		ResponseStructure<Object> structure = new ResponseStructure<>();

		for (ObjectError objectError : error) {
			String filedName = ((FieldError) objectError).getField();
			String message = ((FieldError) objectError).getDefaultMessage();
			map.put(filedName, message);

		}
		structure.setMessage("provide valid details");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(map);

		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		ResponseStructure<Object> structure = new ResponseStructure();
		Map<String, String> map = new HashMap<String, String>();

		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			map.put(field, message);

		}

		structure.setMessage("provide proper details");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(map);

		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);

	}

	@org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlintegrityconstraintViolation(
			SQLIntegrityConstraintViolationException ex) {

		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("you cant perform this opertation");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundByManager.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(IdNotFoundByManager exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Id is not found for manager ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementFoundByManagerException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByManagerException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("element is not found for manager ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(LoginByManagerException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(LoginByManagerException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("pls provide proper pwd  for login manager");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundByBuilding.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(IdNotFoundByBuilding exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("id not found for building");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementFoundByBuildingNameException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByBuildingNameException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("name is  not found for building");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoBuilidngFoundbasedOnPincodeException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoBuilidngFoundbasedOnPincodeException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("pincode  is  not found for building");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoBuilidngFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(NoBuilidngFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("building is not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoBuilidngFoundbasedOnRatingException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoBuilidngFoundbasedOnRatingException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("building is not found based on rating");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementFoundByServiceNameException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByServiceNameException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("building is not found based on rating");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundByFloor.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			IdNotFoundByFloor exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("floor id  is not found ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundByWorkSpace.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			IdNotFoundByWorkSpace exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("WorkSpace id  is not found ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundByDutyAssign.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			IdNotFoundByDutyAssign exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("EmployeeDutyAssign id  is not found ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchWorkSpaceFoundForBooking.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchWorkSpaceFoundForBooking exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("WORKSPACE IS ALREADY BOOKED");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	

	
	

}
