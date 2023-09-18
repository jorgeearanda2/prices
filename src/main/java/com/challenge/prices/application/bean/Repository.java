package com.challenge.prices.application.bean;

import com.challenge.prices.domain.repository.BrandRepository;
import com.challenge.prices.domain.repository.PriceRepository;
import com.challenge.prices.infrastructure.entity.price.PriceMapper;
import com.challenge.prices.infrastructure.repository.brand.BrandRepositoryImpl;
import com.challenge.prices.infrastructure.repository.brand.JpaBrandRepository;
import com.challenge.prices.infrastructure.repository.price.JpaPriceRepository;
import com.challenge.prices.infrastructure.repository.price.PriceRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repository {

	@Bean
	public PriceRepository priceRepository(JpaPriceRepository jpaPriceRepository, PriceMapper priceMapper) {
		return new PriceRepositoryImpl(jpaPriceRepository, priceMapper);
	}

	@Bean
	public BrandRepository brandRepository(JpaBrandRepository jpaBrandRepository) {
		return new BrandRepositoryImpl(jpaBrandRepository);
	}

}
