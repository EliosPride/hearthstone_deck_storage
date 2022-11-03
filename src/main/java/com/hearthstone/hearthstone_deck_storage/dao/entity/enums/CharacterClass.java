package com.hearthstone.hearthstone_deck_storage.dao.entity.enums;

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

    private final int classId;

    CharacterClass(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }
}
