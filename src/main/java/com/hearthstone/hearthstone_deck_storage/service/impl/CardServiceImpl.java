package com.hearthstone.hearthstone_deck_storage.service.impl;

import com.hearthstone.hearthstone_deck_storage.dto.CardDto;
import com.hearthstone.hearthstone_deck_storage.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Override
    public CardDto save(CardDto cardDto) {
        return null;
    }

    @Override
    public List<CardDto> saveAll(List<CardDto> cardDtoList) {
        return null;
    }

    @Override
    public Optional<CardDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CardDto> findAll() {
        return null;
    }

    @Override
    public void delete(CardDto cardDto) {

    }

    @Override
    public void deleteAll(List<CardDto> cardDtoList) {

    }

}
