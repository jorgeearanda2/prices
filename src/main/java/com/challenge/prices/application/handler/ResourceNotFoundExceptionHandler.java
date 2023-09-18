package com.challenge.prices.application.handler;

import com.challenge.prices.application.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ResourceNotFoundExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException e) {
		log.debug(e.getMessage(), e);
		return ResponseEntity.notFound().build();
	}

}
