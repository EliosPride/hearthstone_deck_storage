package com.hearthstone.hearthstone_deck_storage.service;

import com.hearthstone.hearthstone_deck_storage.dto.CardDto;

import java.util.List;
import java.util.Optional;

public interface CardService {

    CardDto save(CardDto cardDto);

    List<CardDto> saveAll(List<CardDto> cardDtoList);

    Optional<CardDto> findById(Long id);

    List<CardDto> findAll();

    void delete(CardDto cardDto);

    void deleteAll(List<CardDto> cardDtoList);
}
