/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Test Suite for the {@link Pricing} object
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pricing implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The pricing Id
	 */
	private Integer pricingId;

	/**
	 * The brand Id
	 */
	private Integer brandId;

	/**
	 * The start date from which the pricing configuration starts to be applied
	 */
	private LocalDateTime startDate;

	/**
	 * the end date until the pricing configuration will be applied
	 */
	private LocalDateTime endDate;

	/**
	 * The product id which is related to the pricing object
	 */
	private Integer productId;

	/**
	 * The priority of this pricing object over other existing pricing register
	 */
	private Integer priority;

	/**
	 * the price for the pricing element
	 */
	private BigDecimal price;

	/**
	 * the currency for this pricing element
	 */
	private String currency;

}
