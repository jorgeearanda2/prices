package com.challenge.prices.application.controller.prices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PricesControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_1_price() throws Exception {
		long brandId = 1L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

		this.mockMvc.perform(get(
				"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
				brandId,
				productId,
				applicationDate
			)).andExpect(
				status().isOk())
			.andExpect(content().json("{'content':  {" +
				" 'productId':  '35455'," +
				" 'brandId':  1, " +
				" 'priceList': 1," +
				" 'startDateTime': '2020-06-14T00:00:00', " +
				" 'endDateTime': '2020-12-31T23:59:59', " +
				" 'price': 35.50, " +
				" 'currency' : 'EUR'" +
				"}}"));
	}

	@Test
	void test_2_price() throws Exception {
		long brandId = 1L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

		this.mockMvc.perform(get(
				"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
				brandId,
				productId,
				applicationDate
			)).andExpect(
				status().isOk())
			.andExpect(content().json("{'content':  {" +
				" 'productId':  '35455'," +
				" 'brandId':  1, " +
				" 'priceList': 2," +
				" 'startDateTime': '2020-06-14T15:00:00', " +
				" 'endDateTime': '2020-06-14T18:30:00', " +
				" 'price': 25.45, " +
				" 'currency' : 'EUR'" +
				"}}"));
	}

	@Test
	void test_3_price() throws Exception {
		long brandId = 1L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0);

		this.mockMvc.perform(get(
				"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
				brandId,
				productId,
				applicationDate
			)).andExpect(
				status().isOk())
			.andExpect(content().json("{'content':  {" +
				" 'productId':  '35455'," +
				" 'brandId':  1, " +
				" 'priceList': 1," +
				" 'startDateTime': '2020-06-14T00:00:00', " +
				" 'endDateTime': '2020-12-31T23:59:59', " +
				" 'price': 35.50, " +
				" 'currency' : 'EUR'" +
				"}}"));
	}

	@Test
	void test_4_price() throws Exception {
		long brandId = 1L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

		this.mockMvc.perform(get(
				"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
				brandId,
				productId,
				applicationDate
			)).andExpect(
				status().isOk())
			.andExpect(content().json("{'content':  {" +
				" 'productId':  '35455'," +
				" 'brandId':  1, " +
				" 'priceList': 3," +
				" 'startDateTime': '2020-06-15T00:00:00', " +
				" 'endDateTime': '2020-06-15T11:00:00', " +
				" 'price': 30.50, " +
				" 'currency' : 'EUR'" +
				"}}"));
	}

	@Test
	void test_5_price() throws Exception {
		long brandId = 1L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

		this.mockMvc.perform(get(
				"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
				brandId,
				productId,
				applicationDate
			)).andExpect(
				status().isOk())
			.andExpect(content().json("{'content':  {" +
				" 'productId':  '35455'," +
				" 'brandId':  1, " +
				" 'priceList': 4," +
				" 'startDateTime': '2020-06-15T16:00:00', " +
				" 'endDateTime': '2020-12-31T23:59:59', " +
				" 'price': 38.95, " +
				" 'currency' : 'EUR'" +
				"}}"));
	}

	@Test
	void test_brand_not_found() throws Exception {
		long brandId = 2L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

		this.mockMvc.perform(get(
			"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
			brandId,
			productId,
			applicationDate
		)).andExpect(
			status().isNotFound());
	}

	@Test
	void test_price_not_found() throws Exception {
		long brandId = 2L;
		String productId = "35455";
		LocalDateTime applicationDate = LocalDateTime.of(2023, 6, 16, 21, 0, 0);

		this.mockMvc.perform(get(
			"/v1/brands/{brandId}/products/{productId}/prices/{applicationDate}",
			brandId,
			productId,
			applicationDate
		)).andExpect(
			status().isNotFound());
	}

}
