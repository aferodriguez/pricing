/**
 * company name 2020 - 2021
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
import com.inditex.pricing.domain.service.PricingService;

import lombok.extern.slf4j.Slf4j;

/**
 * Pricing Search Controller to get the pricing according to the parameters
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
@RestController
@Slf4j
public class PricingSearchController {

	/**
	 *  pricing service which provides business interaction
	 */
	private PricingService pricingService;

	/**
	 * pricing to pricing search response dto converter
	 */
	private PricingToPricingSearchResponseDTOConverter pricingToPricingSearchResponseDTOConverter;

	@Autowired
	public PricingSearchController(final PricingService pricingService,
			final PricingToPricingSearchResponseDTOConverter pricingToPricingSearchResponseDTOConverter) {
		this.pricingService = pricingService;
		this.pricingToPricingSearchResponseDTOConverter = pricingToPricingSearchResponseDTOConverter;
	}

	/**
	 * used to search pricing according to the path variables
	 * 
	 * 
	 * @param productId
	 * @param brandId
	 * @param applicationDate
	 * @return
	 * @throws PricingNotFoundException
	 */
	@GetMapping("/api/pricing/{productId}/{brandId}/{applicationDate}")
	public ResponseEntity<?> searchPricing(@PathVariable final Integer productId, @PathVariable final Integer brandId,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate)
			throws PricingNotFoundException {
		
		log.debug("filtering pricing by productId: {}, brandId: {} and applicationDate: {}", productId, brandId, applicationDate);
		
		return ResponseEntity.status(HttpStatus.OK).body(pricingToPricingSearchResponseDTOConverter
				.convert(pricingService.getPricing(applicationDate, productId, brandId)));
	}
	

}
