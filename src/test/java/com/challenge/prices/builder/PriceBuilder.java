package com.challenge.prices.builder;

import com.challenge.prices.domain.model.Price;

import java.time.LocalDateTime;

public class PriceBuilder {

	public Price build(int index) {
		return new Price(
			index * 2L,
			index * 3L,
			LocalDateTime.of(2022, index % 12, 1, 0, 0, 0),
			LocalDateTime.of(2023, index % 12, 1, 0, 0, 0),
			index * 4L,
			"product-id-" + index,
			index,
			index * 10.0,
			"CURR-" + index
		);
	}

}
