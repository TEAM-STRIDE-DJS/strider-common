package com.strider.strider_common.exception;

import com.strider.strider_common.response.StrideResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalStrideExceptionHandler {

    public GlobalStrideExceptionHandler(){

    }

    @ExceptionHandler(StrideException.class)
    public ResponseEntity<StrideResponse<Object>> handleStrideException(StrideException ex) {
        return ResponseEntity
                .status(ex.getErrorCode().getHttpStatus())
                .body(StrideResponse.error(ex.getErrorCode()));
    }
}
