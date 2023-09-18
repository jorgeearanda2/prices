package com.challenge.prices.infrastructure.repository.brand;

import com.challenge.prices.infrastructure.entity.brand.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long>, JpaSpecificationExecutor<BrandEntity> {

	Optional<BrandEntity> findById(long brandId);

}
