package com.challenge.prices.application.controller.prices.response;

import com.challenge.prices.domain.use_case.PriceInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceInfoResponseMapperTest {

	@InjectMocks
	private PriceInfoResponseMapper mapper;

	@Test
	void when_price_info_is_given_then_response_is_mapped() {
		PriceInfoResponse priceInfoResponse = this.mapper.map(new PriceInfo(
			"product-id",
			5L,
			3L,
			LocalDateTime.of(2022, 12, 10, 0, 0, 0),
			LocalDateTime.of(2023, 12, 10, 0, 0, 0),
			25.0,
			"CURR"
		));

		assertEquals("product-id", priceInfoResponse.getProductId());
		assertEquals(5L, priceInfoResponse.getBrandId());
		assertEquals(3L, priceInfoResponse.getPriceList());
		assertEquals(LocalDateTime.of(2022, 12, 10, 0, 0, 0), priceInfoResponse.getStartDateTime());
		assertEquals(LocalDateTime.of(2023, 12, 10, 0, 0, 0), priceInfoResponse.getEndDateTime());
		assertEquals(25.0, priceInfoResponse.getPrice());
		assertEquals("CURR", priceInfoResponse.getCurrency());
	}

}