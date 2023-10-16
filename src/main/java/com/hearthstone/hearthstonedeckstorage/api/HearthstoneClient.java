package com.hearthstone.hearthstonedeckstorage.api;

import com.hearthstone.hearthstonedeckstorage.dto.CardDto;

import java.util.List;

public interface HearthstoneClient {

    List<CardDto> getCardsBySet(String set);

}
