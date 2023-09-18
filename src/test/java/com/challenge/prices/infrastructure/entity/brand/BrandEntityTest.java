package com.challenge.prices.infrastructure.entity.brand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandEntityTest {

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		BrandEntity brandEntity = new BrandEntity(
			"brand-name"
		).setId(5L);

		assertEquals(5L, brandEntity.getId());
		assertEquals("brand-name", brandEntity.getName());
	}

}