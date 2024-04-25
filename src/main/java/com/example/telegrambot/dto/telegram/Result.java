package com.example.telegrambot.dto.telegram;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Result {
    public int update_id;
    public Message message;
}
