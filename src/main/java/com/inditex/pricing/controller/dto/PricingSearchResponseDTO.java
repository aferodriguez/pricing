/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pricing Search Response DTO
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricingSearchResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * productId
	 */
	private Integer productId;
	
	/**
	 * brand id
	 */
	private Integer brandId;
	
	/**
	 * Date since this pricing applies
	 */
	private LocalDateTime startApplicationDate;
	
	/**
	 * Date until this pricing applies
	 */
	private LocalDateTime endApplicationDate;
	
	/**
	 * the pricingId 
	 */
	private Integer tariff;

	/**
	 * the final price
	 */
	private BigDecimal finalPrice;
	
	/**
	 * text containing the final price with the currency
	 */
	private String finalPriceWithCurrencyText;
	
	
}
