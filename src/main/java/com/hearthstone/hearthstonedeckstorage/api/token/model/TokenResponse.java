package com.hearthstone.hearthstonedeckstorage.api.token.model;

import lombok.Data;

import java.time.Instant;

@Data
public class TokenResponse {
    private String tokenType;
    private String accessToken;
    private Instant expiresIn;
}
