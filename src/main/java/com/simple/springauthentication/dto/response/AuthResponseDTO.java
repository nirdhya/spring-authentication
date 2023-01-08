package com.simple.springauthentication.dto.response;

import lombok.Data;

@Data
public class AuthResponseDTO {

    private String accessToken;
    private String refreshToken;

}
