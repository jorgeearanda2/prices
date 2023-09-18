package com.challenge.prices.domain.use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PriceInfoTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		PriceInfo priceInfo = new PriceInfo(
			"product-id",
			10L,
			5L,
			LocalDateTime.of(2021, 12, 1, 0, 0, 0),
			LocalDateTime.of(2023, 12, 1, 0, 0, 0),
			25.0,
			"CURR"
		);

		assertEquals("product-id", priceInfo.getProductId());
		assertEquals(10L, priceInfo.getBrandId());
		assertEquals(5L, priceInfo.getPriceList());
		assertEquals(LocalDateTime.of(2021, 12, 1, 0, 0, 0), priceInfo.getStartDateTime());
		assertEquals(LocalDateTime.of(2023, 12, 1, 0, 0, 0), priceInfo.getEndDateTime());
		assertEquals(25.0, priceInfo.getPrice());
		assertEquals("CURR", priceInfo.getCurrency());
	}

}