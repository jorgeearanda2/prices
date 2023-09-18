package com.challenge.prices.application.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		ErrorResponse errorResponse = new ErrorResponse("::message::");

		assertEquals("::message::", errorResponse.getMessage());
	}

}