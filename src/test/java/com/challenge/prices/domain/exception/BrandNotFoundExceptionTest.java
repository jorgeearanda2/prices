package com.challenge.prices.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandNotFoundExceptionTest {

	@Test
	void when_exception_is_created_then_data_can_be_retrieved() {
		BrandNotFoundException exception = new BrandNotFoundException("::message::");

		assertEquals("::message::", exception.getMessage());
	}

}