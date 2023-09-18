package com.challenge.prices.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Price {

	private final long id;
	private final long brandId;
	private final LocalDateTime startDate;
	private final LocalDateTime endDate;
	private final long priceList;
	private final String productId;
	private final int priority;
	private final double price;
	private final String curr;

}
