package com.example.telegrambot.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FromRequestDto {
    private Object id;
    private Boolean is_bot;
    private String first_name;
    private String language_code;
}
