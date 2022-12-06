package com.hearthstone.hearthstone_deck_storage.common.converter;

import com.hearthstone.hearthstone_deck_storage.dao.entity.enums.Rarity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RarityConverter implements AttributeConverter<Rarity, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Rarity attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Rarity convertToEntityAttribute(Integer value) {
        if (value == null) {
            return null;
        }
        return Rarity.fromValue(value);
    }
}
