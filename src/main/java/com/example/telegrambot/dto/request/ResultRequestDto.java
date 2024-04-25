package com.example.telegrambot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Message;

@Setter
@Getter
public class ResultRequestDto {
    @JsonProperty("update_id")
    private Integer updateId;
    private Message message;
}
