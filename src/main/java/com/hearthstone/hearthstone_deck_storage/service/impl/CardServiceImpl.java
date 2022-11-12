package com.hearthstone.hearthstone_deck_storage.service.impl;

import com.hearthstone.hearthstone_deck_storage.dao.CardDao;
import com.hearthstone.hearthstone_deck_storage.dao.entity.Card;
import com.hearthstone.hearthstone_deck_storage.dto.CardDto;
import com.hearthstone.hearthstone_deck_storage.service.CardService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardDao cardDao;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public CardDto getOrSave(@NotNull CardDto cardDto) {
        return cardDao.findCardByCardId(cardDto.getCardId()).map(this::convertToDto).orElseGet(() -> {
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
        return cardDao.saveAll(cardList).stream()
                .map(this::convertToDto)
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
        return cardDao.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(@NotNull CardDto cardDto) {
        cardDao.delete(modelMapper.map(cardDto, Card.class));
        log.info("Delete card with cardId " + cardDto.getCardId());
    }

    @Override
    @Transactional
    public void deleteAll() {
        cardDao.deleteAll();
        log.info("Deleting all cards from db");
    }

    private CardDto convertToDto(Card card) {
        return modelMapper.map(card, CardDto.class);
    }
}
