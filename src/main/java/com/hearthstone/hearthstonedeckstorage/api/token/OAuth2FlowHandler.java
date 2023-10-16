package com.hearthstone.hearthstonedeckstorage.api.token;

import com.hearthstone.hearthstonedeckstorage.api.token.model.TokenResponse;

public interface OAuth2FlowHandler {

    TokenResponse getToken();
    
}
