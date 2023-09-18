package com.challenge.prices.application.controller.response;

import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseTest {

	@Test
	void when_response_is_created_then_data_can_be_retrieved() {
		Response<TestA> response = new Response<>(new TestA());

		assertEquals(new TestA(), response.getContent());
	}

	@EqualsAndHashCode
	private static class TestA {

		int seed = 100;

	}


}