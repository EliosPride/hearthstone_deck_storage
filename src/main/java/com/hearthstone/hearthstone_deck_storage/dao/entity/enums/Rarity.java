package com.hearthstone.hearthstone_deck_storage.dao.entity.enums;

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
}
