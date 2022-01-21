package com.bcp.exchange.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcp.exchange.dao.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

	Optional<CurrencyEntity> findByCurrency(String anyStrg);

}
