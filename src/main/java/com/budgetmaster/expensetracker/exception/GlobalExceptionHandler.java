package com.budgetmaster.expensetracker.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 public ResponseEntity<ErrorModel> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
	        ErrorModel errorModel = new ErrorModel();
	        errorModel.setCode("RESOURCE_NOT_FOUND");
	        errorModel.setMessage(ex.getMessage() != null ? ex.getMessage() : "Resource not found");

	        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
	    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorModel>> fieldValidation(MethodArgumentNotValidException manv) {
		List<FieldError> fe = manv.getBindingResult().getFieldErrors();
		List<ErrorModel> errorModelList = new ArrayList<ErrorModel>();
		ErrorModel errorModel = null;
		for (FieldError fieldError : fe) {
			errorModel = new ErrorModel();
			errorModel.setCode(fieldError.getField());
			errorModel.setMessage(fieldError.getDefaultMessage());
			errorModelList.add(errorModel);
		}
		return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
	        return new ResponseEntity<>("Internal Server Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
