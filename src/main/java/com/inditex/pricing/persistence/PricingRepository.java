/**
 * company name 2020 - 2021
 */
package com.inditex.pricing.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.pricing.persistence.dto.PricingEntity;

/**
 * repository for the {@link PricingEntity} object
 * 
 * @author Andres Rodriguez (aferca@hotmail.es)
 * @version 1.0
 * @since 1.0
 */
public interface PricingRepository extends JpaRepository<PricingEntity, Integer> {
	
	/**
	 * 
	 * returns a pricing list with match with the brandId, productId and 
	 * applicationDate
	 * 
	 * @param applicationDate
	 * @param productId
	 * @param brandId
	 * @return the list of pricing according to parameters
	 */
	@Query(value= "SELECT p.* "
			+ "FROM pricing p "
			+ "WHERE p.brand_id = :brandId "
			+ "AND p.product_id = :productId "
			+ "AND :applicationDate BETWEEN p.start_date AND p.endDate ", 
			nativeQuery = true)
	public List<PricingEntity> getPricingList(@Param("applicationDate") LocalDateTime applicationDate,
												@Param("productId") Integer productId,
												@Param("brandId") Integer brandId);
	

	
}
