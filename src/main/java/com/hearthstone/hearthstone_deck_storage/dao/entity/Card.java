package com.hearthstone.hearthstone_deck_storage.dao.entity;

import com.hearthstone.hearthstone_deck_storage.common.config.converter.CharacterClassConverter;
import com.hearthstone.hearthstone_deck_storage.common.config.converter.RarityConverter;
import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.CharacterClass;
import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.Rarity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardId;
    @Convert(converter = CharacterClassConverter.class)
    @Column(name = "class_Id")
    private CharacterClass characterClass;
    @Convert(converter = RarityConverter.class)
    @Column(name = "rarity_Id")
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
