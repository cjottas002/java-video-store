package com.videostore.api.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    public String username;
    public String password;
}
