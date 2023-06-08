package com.example.cadastro.exceptions.handler;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.cadastro.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

import com.example.cadastro.MainApplication;
import com.example.cadastro.exceptions.ExceptionResponse;
import com.example.cadastro.exceptions.NoDataFoundException;
import com.example.cadastro.exceptions.ResourceNotFoundException;

@Slf4j
@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

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
}
