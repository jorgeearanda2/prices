package com.challenge.prices.application.controller.prices;

import com.challenge.prices.application.controller.prices.response.PriceInfoResponse;
import com.challenge.prices.application.controller.prices.response.PriceInfoResponseMapper;
import com.challenge.prices.application.controller.response.Response;
import com.challenge.prices.application.exception.ResourceNotFoundException;
import com.challenge.prices.builder.PriceInfoBuilder;
import com.challenge.prices.builder.PriceInfoResponseBuilder;
import com.challenge.prices.domain.exception.BrandNotFoundException;
import com.challenge.prices.domain.use_case.RetrievePriceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

	@InjectMocks
	private PricesController pricesController;

	@Mock
	private RetrievePriceUseCase retrievePriceUseCase;

	@Mock
	private PriceInfoResponseMapper priceInfoResponseMapper;

	@Test
	void when_input_is_given_then_price_is_retrieved() throws ResourceNotFoundException, BrandNotFoundException {
		when(this.retrievePriceUseCase.execute(
			anyLong(),
			anyString(),
			any()
		)).thenReturn(Optional.of(new PriceInfoBuilder().build(3)));

		this.pricesController.getPrices(5L, "product-id", LocalDateTime.of(2023, 9, 10, 0, 0, 0));

		verify(this.retrievePriceUseCase).execute(5L, "product-id", LocalDateTime.of(2023, 9, 10, 0, 0, 0));
	}

	@Test
	void when_brand_is_not_found_then_exception_is_thrown() throws BrandNotFoundException {
		doThrow(BrandNotFoundException.class).when(this.retrievePriceUseCase).execute(anyLong(), anyString(), any());

		assertThrows(
			ResourceNotFoundException.class,
			() -> this.pricesController.getPrices(5L, "product-id", LocalDateTime.of(2023, 9, 10, 0, 0, 0))
		);
	}

	@Test
	void when_price_is_not_found_then_exception_is_thrown() throws BrandNotFoundException {
		when(this.retrievePriceUseCase.execute(
			anyLong(),
			anyString(),
			any()
		)).thenReturn(Optional.empty());

		assertThrows(
			ResourceNotFoundException.class,
			() -> this.pricesController.getPrices(5L, "product-id", LocalDateTime.of(2023, 9, 10, 0, 0, 0))
		);
	}

	@Test
	void when_price_is_found_then_response_is_mapped() throws ResourceNotFoundException, BrandNotFoundException {
		when(this.retrievePriceUseCase.execute(
			anyLong(),
			anyString(),
			any()
		)).thenReturn(Optional.of(new PriceInfoBuilder().build(3)));

		this.pricesController.getPrices(5L, "product-id", LocalDateTime.of(2023, 9, 10, 0, 0, 0));

		verify(this.priceInfoResponseMapper).map(new PriceInfoBuilder().build(3));
	}

	@Test
	void when_response_is_mapped_then_it_is_returned() throws BrandNotFoundException, ResourceNotFoundException {
		when(this.retrievePriceUseCase.execute(
			anyLong(),
			anyString(),
			any()
		)).thenReturn(Optional.of(new PriceInfoBuilder().build(3)));
		when(this.priceInfoResponseMapper.map(any())).thenReturn(new PriceInfoResponseBuilder().build(3));

		ResponseEntity<Response<PriceInfoResponse>> response = this.pricesController.getPrices(
			5L,
			"product-id",
			LocalDateTime.of(2023, 9, 10, 0, 0, 0)
		);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(new Response<>(new PriceInfoResponseBuilder().build(3)), response.getBody());
	}

}