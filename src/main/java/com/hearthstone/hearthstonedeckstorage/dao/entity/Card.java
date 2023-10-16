package com.hearthstone.hearthstonedeckstorage.dao.entity;

import com.hearthstone.hearthstonedeckstorage.common.converter.CharacterClassConverter;
import com.hearthstone.hearthstonedeckstorage.common.converter.RarityConverter;
import com.hearthstone.hearthstonedeckstorage.dao.entity.enums.CharacterClass;
import com.hearthstone.hearthstonedeckstorage.dao.entity.enums.Rarity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_id")
    private Long cardId;
    @Convert(converter = CharacterClassConverter.class)
    @Column(name = "class_id")
    private CharacterClass characterClass;
    @Convert(converter = RarityConverter.class)
    @Column(name = "rarity_id")
    private Rarity rarity;
    @Column(name = "artist_name")
    private String artistName;
    private int health;
    private int attack;
    @Column(name = "mana_cost")
    private int manaCost;
    private String name;
    private String text;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "flavor_text")
    private String flavorText;
}
