package com.hearthstone.hearthstonedeckstorage.dao;

import com.hearthstone.hearthstonedeckstorage.dao.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardDao extends CrudRepository<Card, Long>  {

    @Override
    List<Card> findAll();

    @Override
    <S extends Card> List<S> saveAll(Iterable<S> entities);

    Optional<Card> findCardByCardId(Long aLong);
}
