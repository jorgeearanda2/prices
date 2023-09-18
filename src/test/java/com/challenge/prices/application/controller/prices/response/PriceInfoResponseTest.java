package com.challenge.prices.application.controller.prices.response;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceInfoResponseTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		PriceInfoResponse priceInfoResponse = new PriceInfoResponse(
			"product-id",
			10L,
			5L,
			LocalDateTime.of(2021, 12, 1, 0, 0, 0),
			LocalDateTime.of(2023, 12, 1, 0, 0, 0),
			25.0,
			"CURR"
		);

		assertEquals("product-id", priceInfoResponse.getProductId());
		assertEquals(10L, priceInfoResponse.getBrandId());
		assertEquals(5L, priceInfoResponse.getPriceList());
		assertEquals(LocalDateTime.of(2021, 12, 1, 0, 0, 0), priceInfoResponse.getStartDateTime());
		assertEquals(LocalDateTime.of(2023, 12, 1, 0, 0, 0), priceInfoResponse.getEndDateTime());
		assertEquals(25.0, priceInfoResponse.getPrice());
		assertEquals("CURR", priceInfoResponse.getCurrency());
	}

}