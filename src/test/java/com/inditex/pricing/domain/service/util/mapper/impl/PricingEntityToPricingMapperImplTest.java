/**
 * company name 2011 - 2021
 */
package com.inditex.pricing.domain.service.util.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.inditex.pricing.domain.model.Pricing;
import com.inditex.pricing.domain.model.PricingTest;
import com.inditex.pricing.persistence.dto.PricingEntity;
import com.inditex.pricing.persistence.dto.PricingEntityTest;

/**
 * Test suite for the {@link PricingEntityToPricingMapperImpl}
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 *
 */
public class PricingEntityToPricingMapperImplTest {
	
	/**
	 * System under Test
	 */
	private PricingEntityToPricingMapperImpl pricingEntityToPricingMapperImpl;
	
	/**
	 * Pricing for tests
	 */
	private Pricing testPricing = PricingTest.createDefaultTestPricing();
	
	/**
	 * Pricing entity for tests
	 */
	private PricingEntity testPricingEntity = PricingEntityTest.createDefaultTestPricingEntity();
	
			
			
	public PricingEntityToPricingMapperImplTest() {
		this.pricingEntityToPricingMapperImpl = new PricingEntityToPricingMapperImpl();
	} 
	
	@Test
	public void shouldConvertPricingEntityToPricing() {
		
		Pricing actualPricing = pricingEntityToPricingMapperImpl.sourceToDestination(testPricingEntity);
		
		Assertions.assertAll("Assert Pricing is Equals to Pricing Entity",
				()-> assertEquals(testPricingEntity.getBrandId(),actualPricing.getBrandId()),
				()-> assertEquals(testPricingEntity.getProductId(),actualPricing.getProductId()),
				()-> assertEquals(testPricingEntity.getPrice(),actualPricing.getPrice()),
				()-> assertEquals(testPricingEntity.getStartDate(),actualPricing.getStartDate()),
				()-> assertEquals(testPricingEntity.getEndDate(),actualPricing.getEndDate()),
				()-> assertEquals(testPricingEntity.getPriority(),actualPricing.getPriority()));
		
	}
	
	
	@Test
	public void shouldConvertPricingToPricingEntity() {
		
		PricingEntity actualPricing = pricingEntityToPricingMapperImpl.destinationToSource(testPricing);
		
		Assertions.assertAll("Assert Pricing is Equals to Pricing Entity",
				()-> assertEquals(testPricing.getBrandId(),actualPricing.getBrandId()),
				()-> assertEquals(testPricing.getProductId(),actualPricing.getProductId()),
				()-> assertEquals(testPricing.getPrice(),actualPricing.getPrice()),
				()-> assertEquals(testPricing.getStartDate(),actualPricing.getStartDate()),
				()-> assertEquals(testPricing.getEndDate(),actualPricing.getEndDate()),
				()-> assertEquals(testPricing.getPriority(),actualPricing.getPriority()));
		
	}
}
