package com.challenge.prices.application.controller.prices;

import com.challenge.prices.application.controller.prices.response.PriceInfoResponse;
import com.challenge.prices.application.controller.prices.response.PriceInfoResponseMapper;
import com.challenge.prices.application.controller.response.Response;
import com.challenge.prices.application.exception.ResourceNotFoundException;
import com.challenge.prices.domain.exception.BrandNotFoundException;
import com.challenge.prices.domain.use_case.PriceInfo;
import com.challenge.prices.domain.use_case.RetrievePriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class PricesController implements PricesApi {

	private final RetrievePriceUseCase retrievePriceUseCase;
	private final PriceInfoResponseMapper priceInfoResponseMapper;

	@Override
	@GetMapping(path = "/brands/{brandId}/products/{productId}/prices/{applicationDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<PriceInfoResponse>> getPrices(
		@PathVariable long brandId,
		@PathVariable String productId,
		@PathVariable LocalDateTime applicationDate
	) throws ResourceNotFoundException {
		Optional<PriceInfo> priceInfoOptional;
		try {
			priceInfoOptional = this.retrievePriceUseCase.execute(brandId, productId, applicationDate);
		} catch(BrandNotFoundException e) {
			throw new ResourceNotFoundException(String.format(
				"Brand %d not found", brandId, productId, applicationDate)
			);
		}

		if(priceInfoOptional.isEmpty()) {
			throw new ResourceNotFoundException(String.format(
				"Price for brand %d, product %s, and application date %s not found",
				brandId,
				productId,
				applicationDate
			)
			);
		}

		return ResponseEntity.ok(new Response<>(this.priceInfoResponseMapper.map(priceInfoOptional.get())));
	}

}
