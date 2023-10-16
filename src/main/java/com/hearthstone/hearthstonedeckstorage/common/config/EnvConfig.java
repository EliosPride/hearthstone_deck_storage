package com.hearthstone.hearthstonedeckstorage.common.config;

import lombok.Data;

@Data
public class EnvConfig
{
    public static final String TOKEN_URL_NAME = "https://oauth.battle.net/token";
    public static final String BASE_URL_NAME = "https://eu.api.blizzard.com/hearthstone/cards";
}
