package com.hearthstone.hearthstone_deck_storage.dao.entity.enums;

import java.util.Objects;

public enum Rarity {
    COMMON(1),
    RARE(3),
    EPIC(4),
    LEGENDARY(5);

    public final int rarityId;

    Rarity(int rarityId) {
        this.rarityId = rarityId;
    }

    public int getRarityId() {
        return rarityId;
    }

    public static Rarity fromValue(Integer id) {
        for (Rarity clazz: values()) {
            if (Objects.equals(id, clazz.getRarityId())) {return clazz;}
        }
        return null;
    }
}
