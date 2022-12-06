package com.hearthstone.hearthstone_deck_storage.controller;

import com.hearthstone.hearthstone_deck_storage.api.HearthstoneClient;
import com.hearthstone.hearthstone_deck_storage.dto.CardDto;
import com.hearthstone.hearthstone_deck_storage.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class TestController {

    private final CardService cardService;
    private final HearthstoneClient hearthstoneClient;

    @GetMapping(value = "api/get/cards")
    public List<CardDto> saveAllCards() {
        return cardService.saveAll(hearthstoneClient.getCardsBySet());
    }

}
