package com.challenge.prices.application.controller.prices;

import com.challenge.prices.application.controller.prices.response.PriceInfoResponse;
import com.challenge.prices.application.controller.response.ErrorResponse;
import com.challenge.prices.application.controller.response.Response;
import com.challenge.prices.application.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

public interface PricesApi {

	@Operation(
		tags = "Prices",
		summary = "Get price information of a given product and brand"
	)
	@ApiResponse(responseCode = "200", description = "Get price information")
	@ApiResponse(responseCode = "404", description = "Price not found", content = @Content)
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
	ResponseEntity<Response<PriceInfoResponse>> getPrices(
		@PathVariable long brandId,
		@PathVariable String productId,
		@PathVariable LocalDateTime applicationDate
	) throws ResourceNotFoundException;

}
