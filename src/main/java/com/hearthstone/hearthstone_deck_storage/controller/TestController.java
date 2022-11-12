package com.hearthstone.hearthstone_deck_storage.controller;

import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.CharacterClass;
import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.Rarity;
import com.hearthstone.hearthstone_deck_storage.dto.CardDto;
import com.hearthstone.hearthstone_deck_storage.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class TestController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public CardDto save(@PathVariable("id") Long id) {
        CardDto cardDto = new CardDto();
        cardDto.setCardId(234324L);
        cardDto.setCharacterClass(CharacterClass.HUNTER);
        cardDto.setRarity(Rarity.LEGENDARY);
        cardDto.setArtistName("Khal drogo");
        cardDto.setHealth(342342);
        cardDto.setAttack(32435342);
        cardDto.setManaCost(1);
        cardDto.setName("Artem");
        cardDto.setText("Battlecry: give all assfuck");
        cardDto.setImageUrl("hkdfkhbkdhbfkhk");
        cardDto.setFlavorText("fjkdhgkfkdlli");
        return cardService.getOrSave(cardDto);
    }

}
