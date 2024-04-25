package com.example.telegrambot.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatRequestDto {
    private Object id;
    private String first_name;
    private String type;
}
