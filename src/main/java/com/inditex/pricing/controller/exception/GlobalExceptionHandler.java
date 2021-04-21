package com.inditex.pricing.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.inditex.pricing.controller.dto.PricingSearchResponseErrorDTO;
import com.inditex.pricing.domain.PricingNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handler for the Pricing not found exception
	 * @param req
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PricingNotFoundException.class)
	public ResponseEntity<PricingSearchResponseErrorDTO> notFoundException(HttpServletRequest req, Exception ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PricingSearchResponseErrorDTO.builder().message(ex.getMessage()).build());
	}
}
