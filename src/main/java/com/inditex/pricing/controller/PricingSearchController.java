/**
 * company name 2011 - 2021
 */
package com.inditex.pricing.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.pricing.controller.util.PricingToPricingSearchResponseDTOConverter;
import com.inditex.pricing.domain.PricingNotFoundException;
import com.inditex.pricing.domain.service.impl.PricingServiceImpl;

/**
 * Pricing Search Controller to get the pricing according to the parameters
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
@RestController
public class PricingSearchController {

	private PricingServiceImpl pricingServiceImpl;
	
	private PricingToPricingSearchResponseDTOConverter pricingToPricingSearchResponseDTOConverter;

	@Autowired
	public PricingSearchController(PricingServiceImpl pricingServiceImpl) {
		this.pricingServiceImpl = pricingServiceImpl;
	}

	/**
	 * 
	 * @return
	 * @throws PricingNotFoundException
	 */
	@GetMapping("/api/pricing/{productId}/{brandId}/{applicationDate}")
	public ResponseEntity<?> searchPricing(@PathVariable final Integer productId, @PathVariable final Integer brandId,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME ) LocalDateTime applicationDate) throws PricingNotFoundException {
		return ResponseEntity.status(HttpStatus.OK)
				.body(pricingServiceImpl.getPricing(applicationDate, productId, brandId));
	}

}
