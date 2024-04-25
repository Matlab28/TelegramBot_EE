package com.example.telegrambot.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MessageRequestDto {
    Integer chat_id;
    String text;
}
