package com.bcp.exchange.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.exchange.bussiness.ExchangeTypeService;
import com.bcp.exchange.dto.ExchangeTypeRequest;
import com.bcp.exchange.dto.ExchangeTypeResponse;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exchange/v1/")
@RequiredArgsConstructor
public class ExchangeTypeController {
	
	@Autowired
	private ExchangeTypeService exchangeTypeService;
	
	@GetMapping
    public Single<ResponseEntity<ExchangeTypeResponse>> getExchangeType(@Validated ExchangeTypeRequest exchangeTypeRequest) {
		return exchangeTypeService.getExchangeType(exchangeTypeRequest)
				.map(p -> ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(p)
				).subscribeOn(Schedulers.io());
    }
	
	@PostMapping
	public Single<ResponseEntity<ExchangeTypeResponse>> modifyExchangeType(@Validated @RequestBody ExchangeTypeRequest exchangeTypeRequest) {
        return exchangeTypeService.modifyExchangeType(exchangeTypeRequest)
        		.map(p -> ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(p)
        		).subscribeOn(Schedulers.io());
    }

}
