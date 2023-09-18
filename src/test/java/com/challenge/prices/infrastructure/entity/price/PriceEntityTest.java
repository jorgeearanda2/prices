package com.challenge.prices.infrastructure.entity.price;

import com.challenge.prices.builder.BrandEntityBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceEntityTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		PriceEntity priceEntity = new PriceEntity(
			new BrandEntityBuilder().build(5),
			LocalDateTime.of(2022, 9, 26, 0, 0, 0),
			LocalDateTime.of(2022, 10, 26, 0, 0, 0),
			9L,
			"product-id",
			1,
			15.0,
			"CURR"
		).setId(3L);

		assertEquals(3L, priceEntity.getId());
		assertEquals(new BrandEntityBuilder().build(5), priceEntity.getBrandEntity());
		assertEquals(LocalDateTime.of(2022, 9, 26, 0, 0, 0), priceEntity.getStartDate());
		assertEquals(LocalDateTime.of(2022, 10, 26, 0, 0, 0), priceEntity.getEndDate());
		assertEquals(9L, priceEntity.getPriceList());
		assertEquals("product-id", priceEntity.getProductId());
		assertEquals(1, priceEntity.getPriority());
		assertEquals(15.00, priceEntity.getPrice());
		assertEquals("CURR", priceEntity.getCurr());
	}

}