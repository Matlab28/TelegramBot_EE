package com.example.telegrambot.dto.telegram;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class From {
    public Object id;
    public boolean is_bot;
    public String first_name;
    public String language_code;
}
