package com.hearthstone.hearthstonedeckstorage.api.impl;

import com.hearthstone.hearthstonedeckstorage.api.HearthstoneClient;
import com.hearthstone.hearthstonedeckstorage.api.token.OAuth2FlowHandler;
import com.hearthstone.hearthstonedeckstorage.api.token.model.TokenResponse;
import com.hearthstone.hearthstonedeckstorage.common.config.EnvConfig;
import com.hearthstone.hearthstonedeckstorage.dto.CardDto;
import com.hearthstone.hearthstonedeckstorage.dto.CardsRO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HearthstoneClientImpl implements HearthstoneClient {

    private final OAuth2FlowHandler oAuth2FlowHandler;
    private final RestTemplate restTemplate;

    @Override
    public List<CardDto> getCardsBySet(String set) {
        TokenResponse tokenResponse = oAuth2FlowHandler.getToken();
        String url = UriComponentsBuilder.fromHttpUrl(EnvConfig.BASE_URL_NAME)
                .queryParam("locale", "en_GB")
                .queryParam("set", set)
                .queryParam("access_token", tokenResponse.getAccessToken())
                .toUriString();

        CardsRO cardsRo = restTemplate.getForObject(url, CardsRO.class);
        if(cardsRo == null || CollectionUtils.isEmpty(cardsRo.getCards())) {
            return Collections.emptyList();
        }
        return cardsRo.getCards();
    }
}
