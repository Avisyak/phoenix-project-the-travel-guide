package com.phoenix.Phoenixprojectwork.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private String refreshToken;
    private String userName;
}
