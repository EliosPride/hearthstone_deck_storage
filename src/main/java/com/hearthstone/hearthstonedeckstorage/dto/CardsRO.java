package com.hearthstone.hearthstonedeckstorage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardsRO {

    private List<CardDto> cards;
    private Integer cardCount;
    private Integer pageCount;
    private Integer page;

}
