package com.hearthstone.hearthstone_deck_storage.dao.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardId;
    private int classId;
    private int cardTypeId;
    private int rarityId;
    private String artistName;
    private int health;
    private int attack;
    private int manaCost;
    private String name;
    @Column(name = "ability")
    private String text;
    private String image;
    private String imageGold;
    private String flavorText;
}
