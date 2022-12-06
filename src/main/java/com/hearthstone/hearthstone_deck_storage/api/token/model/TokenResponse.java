package com.hearthstone.hearthstone_deck_storage.api.token.model;

import lombok.Data;

import java.time.Instant;

@Data
public class TokenResponse {
    private String token_type;
    private String access_token;
    private Instant expires_in;
}
