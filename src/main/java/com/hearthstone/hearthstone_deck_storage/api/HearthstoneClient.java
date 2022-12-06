package com.hearthstone.hearthstone_deck_storage.api;

import com.hearthstone.hearthstone_deck_storage.dto.CardDto;

import java.util.List;

public interface HearthstoneClient {

    List<CardDto> getCardsBySet();

}
