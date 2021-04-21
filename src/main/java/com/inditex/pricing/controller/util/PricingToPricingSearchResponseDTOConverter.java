/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.controller.util;

import org.springframework.stereotype.Component;

import com.inditex.pricing.controller.dto.PricingSearchResponseDTO;
import com.inditex.pricing.domain.model.Pricing;

/**
 * Converter to turn {@link Pricing} into {@link PricingSearchResponseDTO} response 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
@Component
public class PricingToPricingSearchResponseDTOConverter {
	
	/**
	 * method to convert the {@link Pricing} to {@link PricingSearchResponseDTO}
	 * if Pricing is empty
	 * @param pricing
	 * @return
	 */
	public PricingSearchResponseDTO convert(final Pricing pricing ) {
		
		if(pricing == null) {
			return PricingSearchResponseDTO
					.builder()
					.build();
		}
		
		return PricingSearchResponseDTO
				.builder()
				.productId(pricing.getProductId())
				.tariff(pricing.getPricingId())
				.brandId(pricing.getBrandId())
				.finalPrice(pricing.getPrice())
				.startApplicationDate(pricing.getStartDate())
				.endApplicationDate(pricing.getEndDate())
				.finalPriceWithCurrencyText(pricing.getPrice() +" "+ pricing.getCurrency())
				.build();
	}
	

}
