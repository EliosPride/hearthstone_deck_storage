package com.hearthstone.hearthstone_deck_storage.service.impl;

import com.hearthstone.hearthstone_deck_storage.dao.app.CardDao;
import com.hearthstone.hearthstone_deck_storage.dao.entity.Card;
import com.hearthstone.hearthstone_deck_storage.dto.CardDto;
import com.hearthstone.hearthstone_deck_storage.service.CardService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private CardDao cardDao;
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CardDto save(@NotNull CardDto cardDto) {
        return cardDao.findCardByName(cardDto.getName()).map(this::convertToDto).orElseGet(() -> {
            log.info("Saving card " + cardDto.getFlavorText());
            Card card = modelMapper.map(cardDto, Card.class);
            Card savedCard = cardDao.save(card);
            return convertToDto(savedCard);
        });
    }

    @Override
    @Transactional
    public List<CardDto> saveAll(@NotNull List<CardDto> cardDtoList) {
        List<Card> cardList = cardDtoList.stream()
                .map(cardDto -> modelMapper.map(cardDto, Card.class))
                .collect(Collectors.toList());
        List<Card> savedCard = cardDao.saveAll(cardList);
        return savedCard.stream()
                .map(card -> modelMapper.map(card, CardDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CardDto> findById(@NotNull Long id) {
        return cardDao.findById(id).map(this::convertToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> findAll() {
        List<Card> cardList = cardDao.findAll();
        return cardList.stream()
                .map(card -> modelMapper.map(card, CardDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(@NotNull CardDto cardDto) {
        Card card = modelMapper.map(cardDto, Card.class);
        cardDao.delete(card);
        log.info("Delete card " + cardDto.getName());
    }

    @Override
    @Transactional
    public void deleteAll() {
        log.info("Deleting all cards from db");
        cardDao.deleteAll();
    }

    private CardDto convertToDto(Card card) {
        return modelMapper.map(card, CardDto.class);
    }
}
