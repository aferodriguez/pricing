/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricingSearchResponseErrorDTO {
	
	/**
	 * error message
	 */
	private String message;
}
