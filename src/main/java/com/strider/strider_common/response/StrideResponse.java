package com.strider.strider_common.response;

import com.strider.strider_common.enums.StrideErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Builder
@Getter
@AllArgsConstructor
public class StrideResponse<T>{
    public T data;
    public Meta meta;

    public static <T> StrideResponse<T> success(T data) {
        return StrideResponse.<T>builder()
                .data(data)
                .meta(StrideErrorCodes.OK.toMeta())
                .build();
    }

    public static <T> StrideResponse<T> error(StrideErrorCodes errorCode) {
        return StrideResponse.<T>builder()
                .data(null)
                .meta(errorCode.toMeta())
                .build();
    }

    public static <T> StrideResponse<T> responseBuilder(Object data, Class<T> clazz) {
        if (data instanceof StrideErrorCodes errorCode) {
            return StrideResponse.<T>error(errorCode);
        }

        if (data instanceof HttpStatusCode statusCode) {
            StrideErrorCodes errorCode = StrideErrorCodes.fromHttpStatusCode(statusCode);
            return StrideResponse.<T>error(errorCode);
        }

        T castedData = clazz.cast(data);
        return StrideResponse.<T>success(castedData);
    }
}
