package com.challenge.prices.domain.repository;

import com.challenge.prices.domain.model.Price;
import com.challenge.prices.infrastructure.entity.brand.BrandEntity;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

	Optional<Price> find(BrandEntity brandEntity, String productId, LocalDateTime applicationDate);

}
