/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.inditex.pricing.domain.PricingNotFoundException;
import com.inditex.pricing.domain.model.Pricing;
import com.inditex.pricing.domain.model.PricingTest;
import com.inditex.pricing.domain.service.util.mapper.impl.PricingEntityToPricingMapperImpl;
import com.inditex.pricing.persistence.PricingRepository;
import com.inditex.pricing.persistence.dao.PricingEntity;

/**
 * Test suite for the {@link PricingServiceImpl}
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 *
 */
public class PricingServiceImplTest {

	/**
	 * Service under test
	 */
	private PricingServiceImpl pricingServiceImpl;

	/**
	 * mock for the pricing repository
	 */
	@Mock
	private PricingRepository pricingRepository = mock(PricingRepository.class);

	/**
	 * mock for the pricing entity to pricing mapper
	 */
	@Mock
	private PricingEntityToPricingMapperImpl pricingEntityToPricingMapperImpl = mock(
			PricingEntityToPricingMapperImpl.class);

	/**
	 * method to be tested
	 */
	private Method choosePricingWithHighestPriority;

	public PricingServiceImplTest() throws NoSuchMethodException, SecurityException {
		choosePricingWithHighestPriority = PricingServiceImpl.class
				.getDeclaredMethod("choosePricingWithHighestPriority", List.class);
		choosePricingWithHighestPriority.setAccessible(true);

		pricingServiceImpl = new PricingServiceImpl(pricingRepository, pricingEntityToPricingMapperImpl);
	}

	@Test
	public void shouldReturnThePricingWithTheHighestPriority()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		LocalDateTime startDate = LocalDateTime.of(2021, 04, 19, 00, 00, 00, 123456789);
		LocalDateTime endDate = LocalDateTime.of(2021, 04, 19, 23, 59, 00, 123456789);

		LocalDateTime startDate1 = LocalDateTime.of(2021, 04, 11, 00, 00, 00, 123456789);
		LocalDateTime endDate1 = LocalDateTime.of(2021, 04, 12, 00, 00, 00, 123456789);

		Pricing pricing = PricingTest.createParametrizedTestPricing(1, 1, startDate, endDate, 0,
				BigDecimal.valueOf(50.1), 123);
		Pricing expectedHighestPriorityPricing = PricingTest.createParametrizedTestPricing(2, 1, startDate1, endDate1,
				1, BigDecimal.valueOf(45.2), 123);

		Pricing actualHighestPriorityPricing = (Pricing) choosePricingWithHighestPriority.invoke(pricingServiceImpl,
				Arrays.asList(new Pricing[] { pricing, expectedHighestPriorityPricing }));

		assertNotNull(expectedHighestPriorityPricing);
		assertEquals(expectedHighestPriorityPricing.getPricingId(), actualHighestPriorityPricing.getPricingId());
		assertEquals(expectedHighestPriorityPricing.getPrice(), actualHighestPriorityPricing.getPrice());
		assertEquals(expectedHighestPriorityPricing.getBrandId(), actualHighestPriorityPricing.getBrandId());

	}
	
	@Test
	public void shouldReturnTheElementWhenOnePricingMatchExistsForTheQuery() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Pricing pricing = PricingTest.createDefaultTestPricing();
		
		Pricing actualPricing = (Pricing) choosePricingWithHighestPriority.invoke(pricingServiceImpl,
				Arrays.asList(new Pricing[] { pricing }));
		
		assertNotNull(actualPricing);
		assertEquals(pricing.getPricingId(), actualPricing.getPricingId());
		assertEquals(pricing.getPrice(), actualPricing.getPrice());
		assertEquals(pricing.getBrandId(), actualPricing.getBrandId());
		
	}

	@Test
	public void shouldThrowPricingNotFoundExceptionWhenThereAreNotMatches() throws PricingNotFoundException {
		when(pricingEntityToPricingMapperImpl.convertSourceListToDestinationList(Mockito.<PricingEntity>anyList()))
				.thenReturn(null);

		Assertions.assertThrows(PricingNotFoundException.class, () -> {
			pricingServiceImpl.getPricing(LocalDateTime.now(), 1, 1);
		});

	}
	
	


}
