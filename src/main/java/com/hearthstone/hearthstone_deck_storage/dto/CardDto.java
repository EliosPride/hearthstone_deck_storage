package com.hearthstone.hearthstone_deck_storage.dto;

import lombok.Data;

@Data
public class CardDto {
    private int classId;
    private int rarityId;
    private String artistName;
    private int health;
    private int attack;
    private int manaCost;
    private String name;
    private String text;
    private String imageUrl;
    private String flavorText;
}
