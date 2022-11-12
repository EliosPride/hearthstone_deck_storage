package com.hearthstone.hearthstone_deck_storage.dao.entity.enums;

import java.util.Objects;

public enum CharacterClass {
    DEMONHUNTER(1),
    DRUID(2),
    HUNTER(3),
    MAGE(4),
    PALADIN(5),
    PRIEST(6),
    ROGUE(7),
    SHAMAN(8),
    WARLOCK(9),
    WARRIOR(10),
    NEUTRAL(12);

    private final int value;

    CharacterClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterClass fromValue(Integer id) {
        for (CharacterClass characterClass : values()) {
            if (Objects.equals(id, characterClass.getValue())) {
                return characterClass;
            }
        }
        return null;
    }
}
