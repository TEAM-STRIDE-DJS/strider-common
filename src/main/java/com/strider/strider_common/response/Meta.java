package com.strider.strider_common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Meta {
    private String status;
    private Integer code;
    private String message;
}
