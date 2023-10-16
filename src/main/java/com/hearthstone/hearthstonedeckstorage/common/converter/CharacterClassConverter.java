package com.hearthstone.hearthstonedeckstorage.common.converter;

import com.hearthstone.hearthstonedeckstorage.dao.entity.enums.CharacterClass;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CharacterClassConverter implements AttributeConverter<CharacterClass, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CharacterClass attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public CharacterClass convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return CharacterClass.fromValue(dbData);
    }

}
