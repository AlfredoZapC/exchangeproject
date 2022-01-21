package com.bcp.exchange.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class ExchangeTypeRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Positive(message = "El monto debe ser mayor a cero")
	@NotNull(message = "El monto no puede ser vacio")
	private Double amount;

	@NotBlank(message = "Moneda de origen no puede ser vacio")
	private String originCurrency;

	@NotBlank(message = "Moneda de destino no puede ser vacio")
	private String destinationCurrency;

}
