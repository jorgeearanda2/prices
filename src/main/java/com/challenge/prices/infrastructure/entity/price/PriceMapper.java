package com.challenge.prices.infrastructure.entity.price;

import com.challenge.prices.domain.model.Price;

public class PriceMapper {

	public Price map(PriceEntity priceEntity) {
		return new Price(
			priceEntity.getId(),
			priceEntity.getBrandEntity().getId(),
			priceEntity.getStartDate(),
			priceEntity.getEndDate(),
			priceEntity.getPriceList(),
			priceEntity.getProductId(),
			priceEntity.getPriority(),
			priceEntity.getPrice(),
			priceEntity.getCurr()
		);
	}

}
