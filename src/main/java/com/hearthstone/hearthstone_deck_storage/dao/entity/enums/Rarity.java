package com.hearthstone.hearthstone_deck_storage.dao.entity.enums;

import java.util.Objects;

public enum Rarity {
    COMMON(1),
    RARE(3),
    EPIC(4),
    LEGENDARY(5);

    private final int rarityId;

    Rarity(int rarityId) {
        this.rarityId = rarityId;
    }

    public int getRarityId() {
        return rarityId;
    }

    public static Rarity fromValue(Integer id) {
        for (Rarity rarity : values()) {
            if (Objects.equals(id, rarity.getRarityId())) {
                return rarity;
            }
        }
        return null;
    }
}
