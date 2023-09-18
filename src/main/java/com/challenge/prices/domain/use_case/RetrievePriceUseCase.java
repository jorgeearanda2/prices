package com.challenge.prices.domain.use_case;

import com.challenge.prices.domain.exception.BrandNotFoundException;
import com.challenge.prices.domain.repository.BrandRepository;
import com.challenge.prices.domain.repository.PriceRepository;
import com.challenge.prices.infrastructure.entity.brand.BrandEntity;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class RetrievePriceUseCase {

	private final PriceRepository priceRepository;
	private final BrandRepository brandRepository;
	private final PriceInfoCreator priceInfoCreator;

	public Optional<PriceInfo> execute(
		Long brandId,
		String productId,
		LocalDateTime applicationDate
	) throws BrandNotFoundException {

		Optional<BrandEntity> brandEntity = this.brandRepository.find(brandId);
		if(brandEntity.isEmpty()) {
			throw new BrandNotFoundException(String.format("Brand {} not found", brandId));
		}
		return this.priceRepository.find(brandEntity.get(), productId, applicationDate)
			.map(this.priceInfoCreator::create);
	}

}
