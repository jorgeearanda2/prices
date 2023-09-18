package com.challenge.prices.application.bean;

import com.challenge.prices.application.controller.prices.response.PriceInfoResponseMapper;
import com.challenge.prices.domain.use_case.PriceInfoCreator;
import com.challenge.prices.infrastructure.entity.price.PriceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

	@Bean
	public PriceMapper priceMapper() {
		return new PriceMapper();
	}

	@Bean
	public PriceInfoCreator priceInfoCreator() {
		return new PriceInfoCreator();
	}

	@Bean
	public PriceInfoResponseMapper priceInfoResponseMapper() {
		return new PriceInfoResponseMapper();
	}

}
