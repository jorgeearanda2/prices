package com.challenge.prices.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceNotFoundExceptionTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		ResourceNotFoundException exception = new ResourceNotFoundException("message");

		assertEquals("message", exception.getMessage());
	}

}