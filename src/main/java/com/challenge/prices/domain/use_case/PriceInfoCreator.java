package com.challenge.prices.domain.use_case;

import com.challenge.prices.domain.model.Price;

public class PriceInfoCreator {

	public PriceInfo create(Price price) {
		return new PriceInfo(
			price.getProductId(),
			price.getBrandId(),
			price.getPriceList(),
			price.getStartDate(),
			price.getEndDate(),
			price.getPrice(),
			price.getCurr()
		);
	}

}
