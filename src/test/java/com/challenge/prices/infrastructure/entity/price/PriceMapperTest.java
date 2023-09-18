package com.challenge.prices.infrastructure.entity.price;

import com.challenge.prices.builder.BrandEntityBuilder;
import com.challenge.prices.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceMapperTest {

	@InjectMocks
	private PriceMapper priceMapper;

	@Test
	void given_price_entity_price_model_is_mapped() {
		Price price = this.priceMapper.map(
			new PriceEntity(
				new BrandEntityBuilder().build(3).setId(6L),
				LocalDateTime.of(2022, 9, 26, 0, 0, 0),
				LocalDateTime.of(2022, 10, 26, 0, 0, 0),
				9L,
				"product-id",
				1,
				15.0,
				"CURR"
			).setId(3L)
		);

		assertEquals(3L, price.getId());
		assertEquals(6L, price.getBrandId());
		assertEquals(LocalDateTime.of(2022, 9, 26, 0, 0, 0), price.getStartDate());
		assertEquals(LocalDateTime.of(2022, 10, 26, 0, 0, 0), price.getEndDate());
		assertEquals(9L, price.getPriceList());
		assertEquals("product-id", price.getProductId());
		assertEquals(1, price.getPriority());
		assertEquals(15.0, price.getPrice());
		assertEquals("CURR", price.getCurr());
	}

}