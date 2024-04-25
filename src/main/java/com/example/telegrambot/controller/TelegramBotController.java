package com.example.telegrambot.controller;

import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import com.example.telegrambot.service.TelegramBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TelegramBotController {
    private final TelegramBotService service;

    @GetMapping("/updates")
    public TelegramRequestRoot updates() {
        return service.getUpdateService();
    }

    @PostMapping("/send")
    public TelegramResponseRoot sendMessage(@RequestBody TelegramSendDto dto) {
        return service.sendMessage(dto);
    }

}
