package com.challenge.prices.application.controller.handler;

import com.challenge.prices.application.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceNotFoundExceptionHandlerTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		ResourceNotFoundException exception = new ResourceNotFoundException("::message::");

		assertEquals("::message::", exception.getMessage());
	}


}