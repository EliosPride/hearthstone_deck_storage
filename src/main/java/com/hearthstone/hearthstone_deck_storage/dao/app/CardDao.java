package com.hearthstone.hearthstone_deck_storage.dao.app;

import com.hearthstone.hearthstone_deck_storage.dao.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardDao extends CrudRepository<Card, Long>  {

    Card save(Card entity);
    <S extends Card> Iterable<S> saveAll(Iterable<S> entities);
    Optional<Card> findById(Long id);
    List<Card> findAll();
    void deleteById(Long id);
    void deleteAll();
}
