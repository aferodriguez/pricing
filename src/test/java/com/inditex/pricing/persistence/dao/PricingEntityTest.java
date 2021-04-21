/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.inditex.pricing.domain.model.Pricing;
import com.inditex.pricing.persistence.dao.PricingEntity;

/**
 * Test Suite for the {@link PricingEntity} object
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
public class PricingEntityTest {
	
	@Test
	void shouldReturnExpectedProperties(){
		
		final Integer testPriceList = 1;
		final Integer testBrandId = 1;
		final LocalDateTime testStartDate = LocalDateTime.now();
		final LocalDateTime testEndDate = LocalDateTime.now();
		final Integer testPriority = 1;
		final BigDecimal testPrice = BigDecimal.valueOf(45.2);
		final Integer testProductId  = 3231;
		
		PricingEntity pricing = 
				createParametrizedTestPricingEntity(testPriceList, testBrandId, testStartDate, 
				testEndDate, testPriority, testPrice, testProductId);
	
		assertEquals(pricing.getPricingId(), testPriceList);
		assertEquals(pricing.getBrandId(), testBrandId);
		assertEquals(pricing.getStartDate(), testStartDate);
		assertEquals(pricing.getEndDate(), testEndDate);
		assertEquals(pricing.getPriority(), testPriority);
		assertEquals(pricing.getPrice(), testPrice);
		assertEquals(pricing.getProductId(), testProductId);
		
	}

	
	public static  PricingEntity createDefaultTestPricingEntity(){
		return PricingEntity
				.builder()
				.pricingId(0)
				.brandId(1)
				.startDate(LocalDateTime.now())
				.endDate(LocalDateTime.now())
				.priority(0)
				.price(new BigDecimal(53.30))
				.productId(123)
				.build();
	}
	
	public static PricingEntity createParametrizedTestPricingEntity(
			final Integer priceList,final Integer brandId,
			final LocalDateTime startDate, final LocalDateTime endDate,
			final Integer priority, final BigDecimal price, final Integer productId ){
		return PricingEntity
				.builder()
				.pricingId(priceList)
				.brandId(brandId)
				.startDate(startDate)
				.endDate(endDate)
				.priority(priority)
				.price(price)
				.productId(productId)
				.build();
	}
	
	
}
