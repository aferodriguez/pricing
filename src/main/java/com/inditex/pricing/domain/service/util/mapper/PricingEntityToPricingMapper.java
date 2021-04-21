/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.domain.service.util.mapper;

import org.mapstruct.Mapper;

import com.inditex.pricing.domain.model.Pricing;
import com.inditex.pricing.persistence.dao.PricingEntity;

@Mapper(componentModel = "spring")
public interface PricingEntityToPricingMapper {
	
	Pricing sourceToDestination(final PricingEntity pricingEntity);
	PricingEntity destinationToSource(final Pricing pricing);
}
