package com.hearthstone.hearthstonedeckstorage.api.token.impl;

import com.hearthstone.hearthstonedeckstorage.api.token.OAuth2FlowHandler;
import com.hearthstone.hearthstonedeckstorage.api.token.model.TokenResponse;
import com.hearthstone.hearthstonedeckstorage.common.config.EnvConfig;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OAuth2FlowHandlerImpl implements OAuth2FlowHandler {

    @Override
    public TokenResponse getToken() {
        RestTemplate restTemplate = new RestTemplate();
        String type = "grant_type";
        String credentials = "client_credentials";
        String url = UriComponentsBuilder.fromUriString(EnvConfig.TOKEN_URL_NAME)
                .queryParam(type, credentials)
                .toUriString();
        ResponseEntity<TokenResponse> token = restTemplate.exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(createHeaders()),
                TokenResponse.class);
        return token.getBody();
    }

    public HttpHeaders createHeaders() {
        HttpHeaders headers =  new HttpHeaders();
            String auth = "ba3276ab8cc24d4fbe6ed3b8e4743bf2" + ":" + "bkwrkKkx7IxkdlaW3PnqVwQMs264Q97W";
            String authHeader = new String(Base64.encodeBase64(auth.getBytes()));
            headers.add("Authorization", "Basic " + authHeader);
        return headers;
    }
}
