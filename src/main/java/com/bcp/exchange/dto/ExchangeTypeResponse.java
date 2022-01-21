package com.bcp.exchange.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class ExchangeTypeResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double initialAmount;
	private Double finalAmount;
	private String originCurrency;
	private String destinationCurrency;
	private Double exchangeType;
}
