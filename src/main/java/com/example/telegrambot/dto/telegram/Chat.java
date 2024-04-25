package com.example.telegrambot.dto.telegram;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Chat {
    public Object id;
    public String first_name;
    public String type;
}
