package com.example.telegrambot.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelegramResponseRoot {
    private Boolean ok;
    private ResultResponseDto result;
}
