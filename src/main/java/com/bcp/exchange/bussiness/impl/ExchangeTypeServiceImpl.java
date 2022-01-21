package com.bcp.exchange.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.exchange.bussiness.ExchangeTypeService;
import com.bcp.exchange.dao.entity.CurrencyEntity;
import com.bcp.exchange.dao.entity.ExchangeTypeEntity;
import com.bcp.exchange.dao.repository.CurrencyRepository;
import com.bcp.exchange.dao.repository.ExchangeTypeRepository;
import com.bcp.exchange.dto.ExchangeTypeRequest;
import com.bcp.exchange.dto.ExchangeTypeResponse;
import com.bcp.exchange.handling.exception.NotFoundException;

import io.reactivex.Single;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExchangeTypeServiceImpl implements ExchangeTypeService {

	@Autowired
	private ExchangeTypeRepository exchangeTypeRepository;
	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Single<ExchangeTypeResponse> getExchangeType(ExchangeTypeRequest exchangeTypeRequest) {
		CurrencyEntity origin = currencyRepository.findByCurrency(exchangeTypeRequest.getOriginCurrency())
				.orElseThrow(NotFoundException::new);
		CurrencyEntity destination = currencyRepository.findByCurrency(exchangeTypeRequest.getDestinationCurrency())
				.orElseThrow(NotFoundException::new);
		ExchangeTypeEntity exchangeType = exchangeTypeRepository.findByOriginCurrencyAndDestinationCurrency(origin, destination)
				.orElseThrow(NotFoundException::new);
		Double finalAmount = exchangeTypeRequest.getAmount() * exchangeType.getExchangeType();
		
		ExchangeTypeResponse exchangeTypeRsp = ExchangeTypeResponse.builder().finalAmount(finalAmount)
				.initialAmount(exchangeTypeRequest.getAmount()).originCurrency(exchangeTypeRequest.getOriginCurrency())
				.destinationCurrency(exchangeTypeRequest.getDestinationCurrency())
				.exchangeType(exchangeType.getExchangeType()).build();
		return Single.just(exchangeTypeRsp);
	}

	@Override
	public Single<ExchangeTypeResponse> modifyExchangeType(ExchangeTypeRequest exchangeTypeRequest) {
		CurrencyEntity origin = currencyRepository.findByCurrency(exchangeTypeRequest.getOriginCurrency())
				.orElseThrow(NotFoundException::new);
		CurrencyEntity destination = currencyRepository.findByCurrency(exchangeTypeRequest.getDestinationCurrency())
				.orElseThrow(NotFoundException::new);
		ExchangeTypeEntity changeType = exchangeTypeRepository.findByOriginCurrencyAndDestinationCurrency(origin, destination)
				.orElseThrow(NotFoundException::new);
		changeType.setExchangeType(exchangeTypeRequest.getAmount());
		exchangeTypeRepository.saveAndFlush(changeType);
		ExchangeTypeResponse changeDto = ExchangeTypeResponse.builder()
				.originCurrency(changeType.getOriginCurrency().getDescription())
				.destinationCurrency(changeType.getDestinationCurrency().getDescription())
				.exchangeType(changeType.getExchangeType()).build();
		return Single.just(changeDto);
	}
	

}