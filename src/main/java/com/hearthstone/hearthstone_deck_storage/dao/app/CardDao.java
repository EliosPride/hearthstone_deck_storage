package com.hearthstone.hearthstone_deck_storage.dao.app;

import com.hearthstone.hearthstone_deck_storage.dao.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardDao extends CrudRepository<Card, Long>  {

    @Override
    List<Card> findAll();

    @Override
    <S extends Card> List<S> saveAll(Iterable<S> entities);

    Optional<Card> findCardByName(String name);
}
