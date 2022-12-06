package com.hearthstone.hearthstone_deck_storage.api.token;

import com.hearthstone.hearthstone_deck_storage.api.token.model.TokenResponse;

public interface OAuth2FlowHandler {

    TokenResponse getToken();

    boolean isTokenInvalid();
}
