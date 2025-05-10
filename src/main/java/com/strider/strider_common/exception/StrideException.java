package com.strider.strider_common.exception;

import com.strider.strider_common.enums.StrideErrorCodes;
import lombok.Getter;

@Getter
public class StrideException extends RuntimeException {
    private final StrideErrorCodes errorCode;

    public StrideException(StrideErrorCodes errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public StrideErrorCodes getErrorCode() {
        return errorCode;
    }
}
