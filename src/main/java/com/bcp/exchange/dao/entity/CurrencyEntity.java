package com.bcp.exchange.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CURRENCY")
@Data
public class CurrencyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "currency_id", unique=true, nullable=false)
	private Long currencyId;
	
	@Column(name = "currency_description")
	private String description;
	
	@Column(name = "currency", nullable=false)
	private String currency;

}
