/**
 * company name 2011 - 2021
 */
package com.inditex.pricing.domain.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.pricing.domain.PricingNotFoundException;
import com.inditex.pricing.domain.model.Pricing;
import com.inditex.pricing.domain.service.PricingService;
import com.inditex.pricing.domain.service.util.mapper.impl.PricingEntityToPricingMapperImpl;
import com.inditex.pricing.persistence.PricingRepository;

/**
 * Pricing Service Implementation for {@link PricingService}
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
public class PricingServiceImpl implements PricingService {

	/**
	 * The Pricing repository
	 */
	private PricingRepository pricingRepository;

	/**
	 * The pricing entity mapper
	 */
	private PricingEntityToPricingMapperImpl pricingEntityToPricingMapperImpl;

	@Autowired
	public PricingServiceImpl(PricingRepository pricingRepository,
			PricingEntityToPricingMapperImpl pricingEntityToPricingMapperImpl) {
		this.pricingRepository = pricingRepository;
		this.pricingEntityToPricingMapperImpl = pricingEntityToPricingMapperImpl;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pricing getPricing(final LocalDateTime applicationDate, final Integer productId, final Integer brandId)
			throws PricingNotFoundException {

		List<Pricing> pricingList = pricingEntityToPricingMapperImpl.convertSourceListToDestinationList(
				pricingRepository.getPricingList(applicationDate, productId, brandId));

		if (pricingList != null && !pricingList.isEmpty()) {
			return choosePricingWithHighestPriority(pricingList);
		} else {
			throw new PricingNotFoundException(
					"There not exists pricing configuration for the parameters" + applicationDate);
		}

	}

	/**
	 * choose the pricing with the highest priority according to the priority which
	 * has the price.
	 * 
	 * @param pricingList
	 * @return Pricing with the highest priority
	 */
	private Pricing choosePricingWithHighestPriority(final List<Pricing> pricingList) {
		if (pricingList.size() > 1) {
			return pricingList.stream()
					.max((price1, price2) -> Integer.compare(price1.getPriority(), price2.getPriority())).orElse(null);
		}

		return pricingList.get(0);

	}

}
