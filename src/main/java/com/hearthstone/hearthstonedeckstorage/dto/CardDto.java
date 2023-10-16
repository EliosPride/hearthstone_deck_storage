package com.hearthstone.hearthstonedeckstorage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hearthstone.hearthstonedeckstorage.dao.entity.enums.CharacterClass;
import com.hearthstone.hearthstonedeckstorage.dao.entity.enums.Rarity;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {
    @JsonProperty("id")
    private Long cardId;
    @JsonProperty("classId")
    private CharacterClass characterClass;
    @JsonProperty("rarityId")
    private Rarity rarity;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("health")
    private int health;
    @JsonProperty("attack")
    private int attack;
    @JsonProperty("manaCost")
    private int manaCost;
    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;
    @JsonProperty("image")
    private String imageUrl;
    @JsonProperty("flavorText")
    private String flavorText;
}
