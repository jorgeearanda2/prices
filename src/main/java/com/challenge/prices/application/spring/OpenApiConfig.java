package com.challenge.prices.application.spring;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Value("${openapi.serverUrl:}")
	private String serverUrl;

	@Bean
	public OpenAPI openAPIInfo() {
		return new OpenAPI()
			.info(this.getApiInfo())
			.addServersItem(new Server().url(this.serverUrl));
	}

	private Info getApiInfo() {
		return new Info()
			.title("Prices API")
			.description("Prices API design")
			.version("1.0");
	}

}