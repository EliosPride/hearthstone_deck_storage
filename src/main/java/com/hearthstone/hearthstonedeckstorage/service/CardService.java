package com.hearthstone.hearthstonedeckstorage.service;

import com.hearthstone.hearthstonedeckstorage.dto.CardDto;

import java.util.List;
import java.util.Optional;

public interface CardService {

    CardDto getOrSave(CardDto cardDto);

    List<CardDto> saveAll(List<CardDto> cardDtoList);

    Optional<CardDto> findById(Long id);

    List<CardDto> findAll();

    void delete(CardDto cardDto);

    void deleteAll();
}
