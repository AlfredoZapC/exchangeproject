package com.bcp.exchange.handling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bcp.exchange.handling.exception.NotFoundException;
import com.bcp.exchange.handling.exception.ResponseError;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DEFAULT_MESSAGE = "Estamos trabajando para solucionar el problema";
    private static final String NOT_FOUND_MESSAGE = "No existe información disponible";


    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ResponseError> handleNotFound(NotFoundException ex) {
        String message = this.retrieveMessage(ex.getMessage());
        ResponseError rspError = new ResponseError(ex.getCode(), NOT_FOUND_MESSAGE);
        log.error(message, ex.getCause());
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(rspError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> messages = this.retrieveMessages(ex.getBindingResult().getAllErrors());
        return this.handleExceptionInternal(ex, new ResponseError(messages), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> messages = this.retrieveMessages(ex.getAllErrors());
        return this.handleExceptionInternal(ex, new ResponseError(messages), headers, status, request);
    }

    private List<String> retrieveMessages(List<ObjectError> errors) {
        return errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
    }

    private String retrieveMessage(String message) {
        if (StringUtils.hasText(message)) {
            return message;
        }
        return DEFAULT_MESSAGE;
    }

}