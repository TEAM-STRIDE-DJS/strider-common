package com.strider.strider_common.exception;

import com.strider.strider_common.response.StriderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalStriderExceptionHandler {

    public GlobalStriderExceptionHandler(){

    }

    @ExceptionHandler(StriderException.class)
    public ResponseEntity<StriderResponse<Object>> handleStrideException(StriderException ex) {
        return ResponseEntity
                .status(ex.getErrorCode().getHttpStatus())
                .body(StriderResponse.error(ex.getErrorCode()));
    }
}
