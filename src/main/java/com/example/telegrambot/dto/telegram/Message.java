package com.example.telegrambot.dto.telegram;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Message {
    public int message_id;
    public From from;
    public Chat chat;
    public int date;
    public String text;
}
