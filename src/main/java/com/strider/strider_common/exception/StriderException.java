package com.strider.strider_common.exception;

import com.strider.strider_common.enums.StriderErrorCodes;
import lombok.Getter;

@Getter
public class StriderException extends RuntimeException {
    private final StriderErrorCodes errorCode;

    public StriderException(StriderErrorCodes errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public StriderErrorCodes getErrorCode() {
        return errorCode;
    }
}
