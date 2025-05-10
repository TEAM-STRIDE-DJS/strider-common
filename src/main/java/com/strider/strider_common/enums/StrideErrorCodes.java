package com.strider.strider_common.enums;

import com.strider.strider_common.response.Meta;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum StrideErrorCodes {
    OK("success", HttpStatus.OK, 2000, "Request Successed"),
    BAD_REQUEST("fail", HttpStatus.BAD_REQUEST, 4000, "Bad Request"),
    INTERNAL_SERVER_ERROR("fail", HttpStatus.INTERNAL_SERVER_ERROR, 5000, "Internal server error");

    private final String status;
    private final HttpStatusCode httpStatusCode;
    private final Integer code;
    private final String message;

    private StrideErrorCodes(String status, HttpStatusCode httpStatusCode, Integer code, String message){
        this.status = status;
        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
    }

    public static StrideErrorCodes fromHttpStatusCode(HttpStatusCode statusCode) {
        for (StrideErrorCodes errorCode : StrideErrorCodes.values()) {
            if (errorCode.getHttpStatus().value() == statusCode.value()) {
                return errorCode;
            }
        }
        return INTERNAL_SERVER_ERROR;
    }

    public static StrideErrorCodes fromStatusCode(int statusCode) {
        for (StrideErrorCodes errorCode : StrideErrorCodes.values()) {
            if (errorCode.getHttpStatus().value() == statusCode) {
                return errorCode;
            }
        }
        return INTERNAL_SERVER_ERROR;
    }

    public Meta toMeta() {
        return Meta.builder()
                .status(status)
                .code(code)
                .message(message)
                .build();
    }

    public HttpStatusCode getHttpStatus() {
        return httpStatusCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
