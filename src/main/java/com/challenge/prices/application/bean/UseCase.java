package com.challenge.prices.application.bean;

import com.challenge.prices.domain.repository.BrandRepository;
import com.challenge.prices.domain.repository.PriceRepository;
import com.challenge.prices.domain.use_case.PriceInfoCreator;
import com.challenge.prices.domain.use_case.RetrievePriceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCase {

	@Bean
	public RetrievePriceUseCase retrievePriceUseCase(
		PriceRepository priceRepository,
		BrandRepository brandRepository,
		PriceInfoCreator priceInfoCreator
	) {
		return new RetrievePriceUseCase(priceRepository, brandRepository, priceInfoCreator);
	}

}
