package com.challenge.prices.builder;

import com.challenge.prices.domain.use_case.PriceInfo;

import java.time.LocalDateTime;

public class PriceInfoBuilder {

	public PriceInfo build(int index) {
		return new PriceInfo(
			"product-id-" + index,
			index * 2L,
			index * 3L,
			LocalDateTime.of(2022, index % 12, 1, 0, 0, 0),
			LocalDateTime.of(2023, index % 12, 1, 0, 0, 0),
			index * 10.0,
			"CURR-" + index
		);
	}

}
