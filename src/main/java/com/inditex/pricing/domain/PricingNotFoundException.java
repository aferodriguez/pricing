/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.domain;

/**
 * Exception for Pricing Not Found
 * @author Andres Rodriguez (aferca@hotmail.es)
 *
 */
public class PricingNotFoundException extends Exception {

	/**
	 * serial UUID
	 */
	private static final long serialVersionUID = 1L;
	
	public PricingNotFoundException(String message){
		super(message);
	}
	
	
	
	
}
