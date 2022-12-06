package com.hearthstone.hearthstone_deck_storage.dao.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum Rarity {
    COMMON(1),
    RARE(3),
    EPIC(4),
    LEGENDARY(5);

    private final int value;

    Rarity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @JsonValue
    public int valueToJson() {
        return value;
    }

    @JsonCreator
    public static Rarity fromValue(Integer id) {
        for (Rarity rarity : values()) {
            if (Objects.equals(id, rarity.getValue())) {
                return rarity;
            }
        }
        return null;
    }
}
