package com.challenge.prices.application.controller.prices.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceInfoResponse {

	private final String productId;
	private final long brandId;
	private final long priceList;
	private final LocalDateTime startDateTime;
	private final LocalDateTime endDateTime;
	private final double price;
	private final String currency;

}
