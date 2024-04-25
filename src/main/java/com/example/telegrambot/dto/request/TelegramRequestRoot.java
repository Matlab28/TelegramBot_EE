package com.example.telegrambot.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class TelegramRequestRoot {
    private Boolean ok;
    private ArrayList<ResultRequestDto> result;
}
