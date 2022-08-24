package com.bancario.transacaoBanco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerContaBancaria {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerCampoInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
        return new ResponseEntity<>("O campo inserido é inválido", HttpStatus.BAD_REQUEST);

    }
}
