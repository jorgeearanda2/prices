package com.challenge.prices.builder;

import com.challenge.prices.application.controller.prices.response.PriceInfoResponse;

import java.time.LocalDateTime;

public class PriceInfoResponseBuilder {

	public PriceInfoResponse build(int index) {
		return new PriceInfoResponse(
			"product-id-" + index,
			index * 2L,
			index * 3L,
			LocalDateTime.of(2021, 12, 12, 0, 0, 0),
			LocalDateTime.of(2022, 12, 12, 0, 0, 0),
			index * 10.0,
			"CURR-" + index
		);
	}

}
