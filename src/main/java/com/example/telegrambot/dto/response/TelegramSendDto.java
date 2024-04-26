package com.example.telegrambot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelegramSendDto {
    @JsonProperty("chat_id")
    private String chatId;
    private String text;
    @JsonProperty("photo")
    private String photo;
}

