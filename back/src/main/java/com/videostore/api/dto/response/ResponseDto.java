package com.videostore.api.dto.response;

import com.videostore.api.dto.LoginResponse;
import lombok.Data;

@Data
public class ResponseDto<T> {
    private boolean result;
    private T data;
    private String errorMessage;

    public ResponseDto(boolean result, T data, String errorMessage) {
        this.result = result;
        this.data = data;
        this.errorMessage = errorMessage;
    }
}
