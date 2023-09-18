package com.challenge.prices.application.controller.prices.response;

import com.challenge.prices.domain.use_case.PriceInfo;

public class PriceInfoResponseMapper {

	public PriceInfoResponse map(PriceInfo priceInfo) {
		return new PriceInfoResponse(
			priceInfo.getProductId(),
			priceInfo.getBrandId(),
			priceInfo.getPriceList(),
			priceInfo.getStartDateTime(),
			priceInfo.getEndDateTime(),
			priceInfo.getPrice(),
			priceInfo.getCurrency()
		);
	}

}
