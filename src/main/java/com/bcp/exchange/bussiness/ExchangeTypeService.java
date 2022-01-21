package com.bcp.exchange.bussiness;

import com.bcp.exchange.dto.ExchangeTypeRequest;
import com.bcp.exchange.dto.ExchangeTypeResponse;

import io.reactivex.Single;

public interface ExchangeTypeService {

	Single<ExchangeTypeResponse> getExchangeType(ExchangeTypeRequest changeTypeRequestDto);

	Single<ExchangeTypeResponse> modifyExchangeType(ExchangeTypeRequest changeTypeRequestDto);

}
