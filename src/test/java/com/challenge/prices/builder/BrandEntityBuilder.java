package com.challenge.prices.builder;

import com.challenge.prices.infrastructure.entity.brand.BrandEntity;

public class BrandEntityBuilder {

	public BrandEntity build(int index) {
		return new BrandEntity(
			"name" + index
		).setId(index * 2);
	}

}
