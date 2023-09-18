package com.challenge.prices.domain.use_case;

import com.challenge.prices.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceInfoCreatorTest {

	@InjectMocks
	private PriceInfoCreator creator;

	@Test
	void when_price_is_given_then_info_is_created() {
		PriceInfo priceInfo = this.creator.create(new Price(
			5L,
			10L,
			LocalDateTime.of(2022, 5, 12, 0, 0, 0),
			LocalDateTime.of(2023, 12, 31, 0, 0, 0),
			5L,
			"product-id",
			1,
			10.25,
			"CURR"
		));

		assertEquals("product-id", priceInfo.getProductId());
		assertEquals(10L, priceInfo.getBrandId());
		assertEquals(5L, priceInfo.getPriceList());
		assertEquals(LocalDateTime.of(2022, 5, 12, 0, 0, 0), priceInfo.getStartDateTime());
		assertEquals(LocalDateTime.of(2023, 12, 31, 0, 0, 0), priceInfo.getEndDateTime());
		assertEquals(10.25, priceInfo.getPrice());
		assertEquals("CURR", priceInfo.getCurrency());
	}

}