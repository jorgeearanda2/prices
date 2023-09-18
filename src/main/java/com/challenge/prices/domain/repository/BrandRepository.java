package com.challenge.prices.domain.repository;

import com.challenge.prices.infrastructure.entity.brand.BrandEntity;

import java.util.Optional;

public interface BrandRepository {

	Optional<BrandEntity> find(long id);

}
