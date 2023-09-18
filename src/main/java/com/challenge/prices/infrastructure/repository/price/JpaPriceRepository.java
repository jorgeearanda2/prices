package com.challenge.prices.infrastructure.repository.price;

import com.challenge.prices.infrastructure.entity.brand.BrandEntity;
import com.challenge.prices.infrastructure.entity.price.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.Optional;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {

	Optional<PriceEntity> findFirstByBrandEntityAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
		BrandEntity brandEntity,
		String productId,
		LocalDateTime dateTime,
		LocalDateTime endDate
	);

}