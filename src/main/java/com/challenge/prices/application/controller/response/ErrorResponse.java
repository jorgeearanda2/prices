package com.challenge.prices.application.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ErrorResponse {

	@NotNull
	@JsonProperty("message")
	private final String message;

}
