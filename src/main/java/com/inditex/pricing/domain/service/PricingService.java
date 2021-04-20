/**
 * company name 2011 - 2021
 */
package com.inditex.pricing.domain.service;

import java.time.LocalDateTime;

import com.inditex.pricing.domain.PricingNotFoundException;
import com.inditex.pricing.domain.model.Pricing;

/**
 * Pricing Service definition to perform operations related with {@link Pricing}
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
public interface PricingService {

	/**
	 * Used to get the pricing to be applied according to parameters received
	 * 
	 * @param applicationDate
	 * @param productId
	 * @param brandId
	 * @return pricing representation
	 * @throws PricingNotFoundException
	 */
	Pricing getPricing(final LocalDateTime applicationDate, final Integer productId, final Integer brandId)
			throws PricingNotFoundException;

}
