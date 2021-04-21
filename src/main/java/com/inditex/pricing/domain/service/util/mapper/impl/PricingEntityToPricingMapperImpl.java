/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.domain.service.util.mapper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.pricing.domain.model.Pricing;
import com.inditex.pricing.domain.service.util.mapper.PricingEntityToPricingMapper;
import com.inditex.pricing.persistence.dao.PricingEntity;

/**
 * Utility to map from {@link PricingEntity} to {@link Pricing}
 * and vice versa
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 *
 */
@Component
public class PricingEntityToPricingMapperImpl implements PricingEntityToPricingMapper  {

	
	@Override
	public Pricing sourceToDestination(PricingEntity pricingEntity) {
		
		if(pricingEntity == null) {
			return Pricing.builder().build();
		}
		
		return Pricing.builder().pricingId(pricingEntity.getPricingId()).brandId(pricingEntity.getBrandId())
				.productId(pricingEntity.getProductId()).startDate(pricingEntity.getStartDate())
				.endDate(pricingEntity.getEndDate()).priority(pricingEntity.getPriority())
				.price(pricingEntity.getPrice()).currency(pricingEntity.getCurrency()).build();
	}

	@Override
	public PricingEntity destinationToSource(Pricing pricing) {
		
		if(pricing == null) {
			return PricingEntity.builder().build();
		}
		
		return PricingEntity.builder().pricingId(pricing.getPricingId()).brandId(pricing.getBrandId())
				.productId(pricing.getProductId()).startDate(pricing.getStartDate()).endDate(pricing.getEndDate())
				.priority(pricing.getPriority()).price(pricing.getPrice()).currency(pricing.getCurrency()).build();
	}

	public List<Pricing> convertSourceListToDestinationList(List<PricingEntity> pricingEntityList) {

		if (pricingEntityList == null) {
			return Collections.emptyList();
		}
		return pricingEntityList
				.stream()
				.map(pricingEntity -> sourceToDestination(pricingEntity))
				.collect(Collectors.toList());

	}


}
