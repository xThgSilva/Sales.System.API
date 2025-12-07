package com.sales.system.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sales.system.responses.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse (
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				"Not Found.",
				ex.getMessage()
			);

			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
