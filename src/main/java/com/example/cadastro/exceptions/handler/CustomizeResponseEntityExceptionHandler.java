package com.example.cadastro.exceptions.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.cadastro.exceptions.ExceptionResponse;
import com.example.cadastro.exceptions.ExceptionValidationResponse;
import com.example.cadastro.exceptions.NoDataFoundException;
import com.example.cadastro.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler  {

		/*tratamento generalizado para exceções*/
		@ExceptionHandler(Exception.class)
		public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
			log.info("handleAllExceptions");
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					new Date(),
					ex.getMessage(),
					request.getDescription(false)
					); 
			
			
			return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		@ExceptionHandler(ResourceNotFoundException.class)
		public final ResponseEntity<ExceptionResponse> handleNotFoundRequestExceptions(Exception ex, WebRequest request) {
			log.info("handleNotFoundRequestExceptions");
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					new Date(),
					ex.getMessage(),
					request.getDescription(false)
					); 
			
			return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
		}
		
		
		@ExceptionHandler(NoDataFoundException.class)
		public final ResponseEntity<ExceptionResponse> handleNoDataFoundException(Exception ex, WebRequest request) {
			log.info("handleNoDataFoundException");
			
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					new Date(),
					ex.getMessage(),
					request.getDescription(false)
					); 
			
			return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public final ResponseEntity<ExceptionValidationResponse> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {
			log.info("handleNotNullValidException");
			
			List<String> errors = ex.getBindingResult().getFieldErrors()
					.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
			
			
			
			
			ExceptionValidationResponse exceptionValidationResponse = new ExceptionValidationResponse(
					new Date(),
					errors,
					request.getDescription(false)
					); 
			
			return new ResponseEntity<>(exceptionValidationResponse, HttpStatus.BAD_REQUEST);
		
			
		}
		

}
