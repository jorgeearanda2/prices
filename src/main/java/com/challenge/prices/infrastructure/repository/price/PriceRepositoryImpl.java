package com.challenge.prices.infrastructure.repository.price;

import com.challenge.prices.domain.model.Price;
import com.challenge.prices.domain.repository.PriceRepository;
import com.challenge.prices.infrastructure.entity.brand.BrandEntity;
import com.challenge.prices.infrastructure.entity.price.PriceMapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

	private final JpaPriceRepository jpaPriceRepository;
	private final PriceMapper priceMapper;

	@Override
	public Optional<Price> find(BrandEntity brandEntity, String productId, LocalDateTime applicationDate) {
		return this.jpaPriceRepository.findFirstByBrandEntityAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			brandEntity,
			productId,
			applicationDate,
			applicationDate
		).map(this.priceMapper::map);
	}

}
