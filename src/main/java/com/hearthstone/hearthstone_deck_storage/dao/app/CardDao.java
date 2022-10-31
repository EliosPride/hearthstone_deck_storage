package com.hearthstone.hearthstone_deck_storage.dao.app;

import com.hearthstone.hearthstone_deck_storage.dao.entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card, Long>  {
}
