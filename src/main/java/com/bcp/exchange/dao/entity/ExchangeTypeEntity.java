package com.bcp.exchange.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EXCHANGE_TYPE")
@Data
public class ExchangeTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exchange_type_id", unique = true, nullable = false)
	private Long exchangeTypeId;

	@Column(name = "exchange_type")
	private Double exchangeType;

	@ManyToOne
	@JoinColumn(name = "origin_currency", nullable = false)
	private CurrencyEntity originCurrency;

	@ManyToOne
	@JoinColumn(name = "destination_currency", nullable = false)
	private CurrencyEntity destinationCurrency;
}
