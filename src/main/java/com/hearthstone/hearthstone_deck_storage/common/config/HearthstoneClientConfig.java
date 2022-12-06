package com.hearthstone.hearthstone_deck_storage.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "hearthstone")
@Data
public class HearthstoneClientConfig implements ApiClientConfig{
    String baseUrl;
    String tokenUrl;
}
