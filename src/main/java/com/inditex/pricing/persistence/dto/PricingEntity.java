/**
 * company name 2011 - 2021
 */
package com.inditex.pricing.persistence.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Andres Rodriguez (anferca@hotmail.es)
 * @since 1.0
 * @version 1.0
 * 
 *          Data base representation for Pricing object
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pricing")
public class PricingEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	/**
	 * The pricing Id
	 */
	@Id
	@Column(name = "pricingId")
	private Integer pricingId;

	/**
	 * The brand Id
	 */
	@Column(name = "brand_id")
	private Integer brandId;

	/**
	 * The start date from which the pricing configuration starts to be applied
	 */
	@Column(name = "start_date")
	private LocalDateTime startDate;

	/**
	 * the end date until the pricing configuration will be applied
	 */
	@Column(name = "end_date")
	private LocalDateTime endDate;

	/**
	 * The product id which is related to the pricing object
	 */
	@Column(name = "product_id")
	private Integer productId;

	/**
	 * The priority of this pricing object over other existing pricing register
	 */
	@Column(name = "priority")
	private Integer priority;

	/**
	 * the price for the pricing element
	 */
	@Column(name = "price")
	private BigDecimal price;

	/**
	 * the currency for this pricing element
	 */
	@Column(name = "currency")
	private String currency;

}
