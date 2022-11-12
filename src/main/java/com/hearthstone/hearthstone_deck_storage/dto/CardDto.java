package com.hearthstone.hearthstone_deck_storage.dto;

import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.CharacterClass;
import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.Rarity;
import lombok.Data;

@Data
public class CardDto {
    private Long id;
    private Long cardId;
    private CharacterClass characterClass;
    private Rarity rarity;
    private String artistName;
    private int health;
    private int attack;
    private int manaCost;
    private String name;
    private String text;
    private String imageUrl;
    private String flavorText;
}
