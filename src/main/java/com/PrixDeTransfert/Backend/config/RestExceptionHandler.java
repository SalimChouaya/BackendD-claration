package com.PrixDeTransfert.Backend.config;

 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { com.PrixDeTransfert.Backend.exceptions.AppException.class })
    @ResponseBody
    public ResponseEntity<com.PrixDeTransfert.Backend.dto.ErrorDto> handleException(com.PrixDeTransfert.Backend.exceptions.AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new com.PrixDeTransfert.Backend.dto.ErrorDto(ex.getMessage()));
    }
}
