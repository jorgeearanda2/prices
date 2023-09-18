package com.challenge.prices.domain.use_case;

import com.challenge.prices.builder.BrandEntityBuilder;
import com.challenge.prices.builder.PriceBuilder;
import com.challenge.prices.builder.PriceInfoBuilder;
import com.challenge.prices.domain.exception.BrandNotFoundException;
import com.challenge.prices.domain.repository.BrandRepository;
import com.challenge.prices.domain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrievePriceUseCaseTest {

	@InjectMocks
	private RetrievePriceUseCase retrievePriceUseCase;

	@Mock
	private PriceRepository priceRepository;

	@Mock
	private BrandRepository brandRepository;

	@Mock
	private PriceInfoCreator priceInfoCreator;

	@Test
	void when_input_is_given_then_brand_is_searched() throws BrandNotFoundException {
		when(this.brandRepository.find(anyLong())).thenReturn(Optional.of(new BrandEntityBuilder().build(3)));

		this.retrievePriceUseCase.execute(5L, "product-id", LocalDateTime.of(2022, 12, 1, 0, 0, 0));

		verify(this.brandRepository).find(5L);
	}

	@Test
	void when_brand_is_not_found_then_exception_is_thrown() {
		when(this.brandRepository.find(anyLong())).thenReturn(Optional.empty());

		assertThrows(
			BrandNotFoundException.class,
			() -> this.retrievePriceUseCase.execute(5L, "product-id", LocalDateTime.of(2022, 12, 1, 0, 0, 0))
		);
	}

	@Test
	void when_brand_is_found_then_price_is_searched() throws BrandNotFoundException {
		when(this.brandRepository.find(anyLong())).thenReturn(Optional.of(new BrandEntityBuilder().build(3)));

		this.retrievePriceUseCase.execute(5L, "product-id", LocalDateTime.of(2022, 12, 1, 0, 0, 0));

		verify(this.priceRepository).find(
			new BrandEntityBuilder().build(3),
			"product-id",
			LocalDateTime.of(2022, 12, 1, 0, 0, 0)
		);
	}

	@Test
	void when_price_is_not_found_then_empty_is_returned() throws BrandNotFoundException {
		when(this.brandRepository.find(anyLong())).thenReturn(Optional.of(new BrandEntityBuilder().build(3)));
		when(this.priceRepository.find(any(), anyString(), any())).thenReturn(Optional.empty());

		Optional<PriceInfo> optionalPriceInfo = this.retrievePriceUseCase.execute(
			5L,
			"product-id",
			LocalDateTime.of(2022, 12, 1, 0, 0, 0)
		);

		assertEquals(Optional.empty(), optionalPriceInfo);
	}

	@Test
	void when_price_is_found_then_price_info_is_created() throws BrandNotFoundException {
		when(this.brandRepository.find(anyLong())).thenReturn(Optional.of(new BrandEntityBuilder().build(3)));
		when(this.priceRepository.find(
			any(),
			anyString(),
			any()
		)).thenReturn(Optional.of(new PriceBuilder().build(2)));

		this.retrievePriceUseCase.execute(
			5L,
			"product-id",
			LocalDateTime.of(2022, 12, 1, 0, 0, 0)
		);

		verify(this.priceInfoCreator).create(new PriceBuilder().build(2));
	}

	@Test
	void when_price_info_is_created_then_it_is_returned() throws BrandNotFoundException {
		when(this.brandRepository.find(anyLong())).thenReturn(Optional.of(new BrandEntityBuilder().build(3)));
		when(this.priceRepository.find(
			any(),
			anyString(),
			any()
		)).thenReturn(Optional.of(new PriceBuilder().build(2)));
		when(this.priceInfoCreator.create(any())).thenReturn(new PriceInfoBuilder().build(3));

		Optional<PriceInfo> optionalPriceInfo = this.retrievePriceUseCase.execute(
			5L,
			"product-id",
			LocalDateTime.of(2022, 12, 1, 0, 0, 0)
		);

		assertEquals(Optional.of(new PriceInfoBuilder().build(3)), optionalPriceInfo);
	}

}