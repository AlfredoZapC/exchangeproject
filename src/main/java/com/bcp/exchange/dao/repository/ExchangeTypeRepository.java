package com.bcp.exchange.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcp.exchange.dao.entity.CurrencyEntity;
import com.bcp.exchange.dao.entity.ExchangeTypeEntity;

public interface ExchangeTypeRepository extends JpaRepository<ExchangeTypeEntity, Long> {

	Optional<ExchangeTypeEntity> findByOriginCurrencyAndDestinationCurrency(CurrencyEntity currencyEntity,
			CurrencyEntity currencyEntitySecond);
}
