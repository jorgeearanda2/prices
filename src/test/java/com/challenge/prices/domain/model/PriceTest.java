package com.challenge.prices.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		Price price = new Price(
			5L,
			10L,
			LocalDateTime.of(2023, 9, 26, 0, 0, 0),
			LocalDateTime.of(2023, 10, 26, 0, 0, 0),
			15L,
			"product-id",
			0,
			25.50,
			"CURR"
		);

		assertEquals(5L, price.getId());
		assertEquals(10L, price.getBrandId());
		assertEquals(LocalDateTime.of(2023, 9, 26, 0, 0, 0), price.getStartDate());
		assertEquals(LocalDateTime.of(2023, 10, 26, 0, 0, 0), price.getEndDate());
		assertEquals(15L, price.getPriceList());
		assertEquals("product-id", price.getProductId());
		assertEquals(0, price.getPriority());
		assertEquals(25.50, price.getPrice());
		assertEquals("CURR", price.getCurr());
	}

}