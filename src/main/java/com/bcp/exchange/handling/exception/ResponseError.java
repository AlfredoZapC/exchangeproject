package com.bcp.exchange.handling.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError {

    public ResponseError() {
    }

    public ResponseError(String code) {
        this.code = code;
    }

    public ResponseError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseError(String code, List<String> messages) {
        this.code = code;
        this.messages = messages;
    }

    public ResponseError(List<String> messages) {
        this.messages = messages;
    }

    public ResponseError(String code, String message, List<String> messages) {
        this.code = code;
        this.message = message;
        this.messages = messages;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> messages;

}