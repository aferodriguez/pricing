package com.inditex.pricing.controller.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.pricing.controller.util.PricingToPricingSearchResponseDTOConverter;
import com.inditex.pricing.domain.service.PricingService;

@Component
public class PricingSearchDelegate {
	
	private PricingService pricingService;
	
	private PricingToPricingSearchResponseDTOConverter pricingToPricingSearchResponseDTOConverter;

	@Autowired
	public PricingSearchDelegate(final PricingService pricingService,
			final PricingToPricingSearchResponseDTOConverter pricingToPricingSearchResponseDTOConverter) {
		this.pricingService = pricingService;
		this.pricingToPricingSearchResponseDTOConverter = pricingToPricingSearchResponseDTOConverter;
	}

}
