package com.hearthstone.hearthstone_deck_storage.api.impl;

import com.hearthstone.hearthstone_deck_storage.api.HearthstoneClient;
import com.hearthstone.hearthstone_deck_storage.api.token.OAuth2FlowHandler;
import com.hearthstone.hearthstone_deck_storage.api.token.model.TokenResponse;
import com.hearthstone.hearthstone_deck_storage.common.config.EnvConfig;
import com.hearthstone.hearthstone_deck_storage.dto.CardDto;
import com.hearthstone.hearthstone_deck_storage.dto.CardsRO;
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
    public List<CardDto> getCardsBySet() {
        TokenResponse tokenResponse = oAuth2FlowHandler.getToken();
        String url = UriComponentsBuilder.fromHttpUrl(EnvConfig.BASE_URL_NAME)
                .queryParam("locale", "en_GB")
                .queryParam("set", "rise-of-shadows")
                .queryParam("access_token", tokenResponse.getAccess_token())
                .toUriString();

        CardsRO cardsRo = restTemplate.getForObject(url, CardsRO.class);
        if(cardsRo == null || CollectionUtils.isEmpty(cardsRo.getCards())) {
            return Collections.emptyList();
        }
        return cardsRo.getCards();
    }
}
