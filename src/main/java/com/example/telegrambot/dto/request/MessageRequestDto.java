package com.example.telegrambot.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageRequestDto {
    private Integer message_id;
    private FromRequestDto from;
    private ChatRequestDto chat;
    private Integer date;
    private String text;
}
