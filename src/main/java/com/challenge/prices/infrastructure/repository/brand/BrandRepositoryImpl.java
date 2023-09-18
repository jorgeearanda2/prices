package com.challenge.prices.infrastructure.repository.brand;

import com.challenge.prices.domain.repository.BrandRepository;
import com.challenge.prices.infrastructure.entity.brand.BrandEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

	private final JpaBrandRepository jpaBrandRepository;

	@Override
	public Optional<BrandEntity> find(long id) {
		return jpaBrandRepository.findById(id);
	}

}
