/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.pricing.PricingApplication;
import com.inditex.pricing.conf.IntegrationTestConfig;
import com.inditex.pricing.conf.TestJpaConfig;
import com.inditex.pricing.controller.dto.PricingSearchResponseDTO;
import com.inditex.pricing.domain.service.impl.PricingServiceImpl;

/**
 * Integration test for the  {@link PricingSearchController}
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { PricingApplication.class,
		TestJpaConfig.class, IntegrationTestConfig.class })
public class PricingSearchControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String server = "http://localhost";
	
	private String pricingApiUri = "/api/pricing/{productId}/{brandId}/{applicationDate}";

	@Test
	public void Test1() {
		
		PricingSearchResponseDTO responseBody = restTemplate.getForEntity(
				server+":" + port+ pricingApiUri,
				PricingSearchResponseDTO.class, 35455, 1, LocalDateTime.of(2020, 06, 14, 10, 00, 00)).getBody();

		
		Assertions.assertAll("Should return the expected response body",
				()->assertEquals(35455, responseBody.getProductId()),
				()->assertEquals(1, responseBody.getBrandId()),
				()->assertNotNull(responseBody.getStartApplicationDate()),
				()->assertNotNull(responseBody.getEndApplicationDate()),
				()->assertEquals(responseBody.getStartApplicationDate(), LocalDateTime.of(2020, 06, 14, 00, 00, 00)),
				()->assertEquals(responseBody.getEndApplicationDate(), LocalDateTime.of(2020, 12, 31, 23, 59, 59)),
				()->assertEquals(responseBody.getFinalPrice(), BigDecimal.valueOf(35.5)),
				()->assertEquals(responseBody.getFinalPriceWithCurrencyText(), BigDecimal.valueOf(35.5)+ " EUR"),
				()->assertEquals(responseBody.getTariff(), 1));

	}
	
	@Test
	public void Test2() {
		
		PricingSearchResponseDTO responseBody = restTemplate.getForEntity(
				server+":" + port+ pricingApiUri,
				PricingSearchResponseDTO.class, 35455, 1, LocalDateTime.of(2020, 06, 14, 16, 00, 00)).getBody();

		
		Assertions.assertAll("Should return the expected response body ",
				()->assertEquals(35455, responseBody.getProductId()),
				()->assertEquals(1, responseBody.getBrandId()),
				()->assertNotNull(responseBody.getStartApplicationDate()),
				()->assertNotNull(responseBody.getEndApplicationDate()),
				()->assertEquals(responseBody.getStartApplicationDate(), LocalDateTime.of(2020, 06, 14, 15, 00, 00)),
				()->assertEquals(responseBody.getEndApplicationDate(), LocalDateTime.of(2020, 06, 14, 18, 30, 00)),
				()->assertEquals(responseBody.getFinalPrice(), BigDecimal.valueOf(25.45)),
				()->assertEquals(responseBody.getFinalPriceWithCurrencyText(), BigDecimal.valueOf(25.45)+ " EUR"),
				()->assertEquals(responseBody.getTariff(), 2));
	}
	
	
	@Test
	public void Test3() {
		
		PricingSearchResponseDTO responseBody = restTemplate.getForEntity(
				server+":" + port+ pricingApiUri,
				PricingSearchResponseDTO.class, 35455, 1, LocalDateTime.of(2020, 06, 14, 21, 00, 00)).getBody();

		
		Assertions.assertAll("Should return the expected response body",
				()->assertEquals(35455, responseBody.getProductId()),
				()->assertEquals(1, responseBody.getBrandId()),
				()->assertNotNull(responseBody.getStartApplicationDate()),
				()->assertNotNull(responseBody.getEndApplicationDate()),
				()->assertEquals(responseBody.getStartApplicationDate(), LocalDateTime.of(2020, 06, 14, 00, 00, 00)),
				()->assertEquals(responseBody.getEndApplicationDate(), LocalDateTime.of(2020, 12, 31, 23, 59, 59)),
				()->assertEquals(responseBody.getFinalPrice(), BigDecimal.valueOf(35.5)),
				()->assertEquals(responseBody.getFinalPriceWithCurrencyText(), BigDecimal.valueOf(35.5)+ " EUR"),
				()->assertEquals(responseBody.getTariff(), 1));

	}
	
	
	@Test
	public void Test4() {
		
		PricingSearchResponseDTO responseBody = restTemplate.getForEntity(
				server+":" + port+ pricingApiUri,
				PricingSearchResponseDTO.class, 35455, 1, LocalDateTime.of(2020, 06, 15, 10, 00, 00)).getBody();
		
		Assertions.assertAll("Should return the expected response body",
				()->assertEquals(35455, responseBody.getProductId()),
				()->assertEquals(1, responseBody.getBrandId()),
				()->assertNotNull(responseBody.getStartApplicationDate()),
				()->assertNotNull(responseBody.getEndApplicationDate()),
				()->assertEquals(responseBody.getStartApplicationDate(), LocalDateTime.of(2020, 06, 15, 00, 00, 00)),
				()->assertEquals(responseBody.getEndApplicationDate(), LocalDateTime.of(2020, 06, 15, 11, 00, 00)),
				()->assertEquals(responseBody.getFinalPrice(), BigDecimal.valueOf(30.5)),
				()->assertEquals(responseBody.getFinalPriceWithCurrencyText(), BigDecimal.valueOf(30.5)+ " EUR"),
				()->assertEquals(responseBody.getTariff(),3));

	}
	
	@Test
	public void Test5() {
		
		PricingSearchResponseDTO responseBody = restTemplate.getForEntity(
				server+":" + port+ pricingApiUri,
				PricingSearchResponseDTO.class, 35455, 1, LocalDateTime.of(2020, 06, 16, 21, 00, 00)).getBody();
		
		Assertions.assertAll("Should return the expected response body",
				()->assertEquals(35455, responseBody.getProductId()),
				()->assertEquals(1, responseBody.getBrandId()),
				()->assertNotNull(responseBody.getStartApplicationDate()),
				()->assertNotNull(responseBody.getEndApplicationDate()),
				()->assertEquals(responseBody.getStartApplicationDate(), LocalDateTime.of(2020, 06, 15, 16, 00, 00)),
				()->assertEquals(responseBody.getEndApplicationDate(), LocalDateTime.of(2020, 12, 31, 23, 59, 59)),
				()->assertEquals(responseBody.getFinalPrice(), BigDecimal.valueOf(38.95)),
				()->assertEquals(responseBody.getFinalPriceWithCurrencyText(), BigDecimal.valueOf(38.95)+ " EUR"),
				()->assertEquals(responseBody.getTariff(),4));

	}

}
