package com.hearthstone.hearthstone_deck_storage.api.token.impl;

import com.hearthstone.hearthstone_deck_storage.api.token.OAuth2FlowHandler;
import com.hearthstone.hearthstone_deck_storage.api.token.model.TokenResponse;
import com.hearthstone.hearthstone_deck_storage.common.config.ApiClientConfig;
import com.hearthstone.hearthstone_deck_storage.common.config.EnvConfig;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuth2FlowHandlerImpl implements OAuth2FlowHandler {

    @Autowired
    private ApiClientConfig apiClientConfig;


    @Override
    public TokenResponse getToken() {
        RestTemplate restTemplate = new RestTemplate();
        String type = "grant_type";
        String credentials = "client_credentials";
        ResponseEntity<TokenResponse> token = restTemplate.exchange(EnvConfig.TOKEN_URL_NAME + "?" + type + "=" + credentials,
                HttpMethod.POST,
                new HttpEntity<>(createHeaders(EnvConfig.CLIENT_ID, EnvConfig.CLIENT_SECRET)),
                TokenResponse.class);
        return token.getBody();
    }

    @Override
    public boolean isTokenInvalid() {
        return true;
    }

    public HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            String authHeader = new String(Base64.encodeBase64(auth.getBytes()));
            set("Authorization", "Basic " + authHeader);
        }};
    }
}
