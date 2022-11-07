package com.hearthstone.hearthstone_deck_storage.common.config.converter;

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
        return attribute.getRarityId();
    }

    @Override
    public Rarity convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Rarity.fromValue(dbData);
    }
}
