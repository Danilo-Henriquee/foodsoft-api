package com.henrique.workshopmongo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.henrique.workshopmongo.services.exception.AlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<StandardError> alreadyExists(AlreadyExistsException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(Instant.now(), status.value(), status.name(), e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
