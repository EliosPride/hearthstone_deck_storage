package com.hearthstone.hearthstonedeckstorage.controller;

import com.hearthstone.hearthstonedeckstorage.api.HearthstoneClient;
import com.hearthstone.hearthstonedeckstorage.dto.CardDto;
import com.hearthstone.hearthstonedeckstorage.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    
    private final CardService cardService;
    private final HearthstoneClient hearthstoneClient;
    
    
    @PutMapping("/{set}")
    public List<CardDto> saveAllCards(@PathVariable String set) {
        return cardService.saveAll(hearthstoneClient.getCardsBySet(set));
    }
    
    @PutMapping("/{id}")
    public void saveOneCard(@PathVariable Long id) {
        CardDto cardById = cardService.findById(id).orElseThrow();
        cardService.getOrSave(cardById);
    }
    
    @GetMapping("/{id}")
    public CardDto getCard(@PathVariable Long id) {
        return cardService.findById(id).orElseThrow();
    }
    
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        CardDto cardDto = cardService.findById(id).orElseThrow();
        cardService.delete(cardDto);
    }
}
