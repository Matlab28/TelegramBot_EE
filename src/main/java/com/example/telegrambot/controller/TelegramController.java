package com.example.telegrambot.controller;

import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import com.example.telegrambot.service.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/telegram")
public class TelegramController {
    private final TelegramService service;

    @PostMapping("/send")
    public TelegramResponseRoot sendMessage(@RequestBody TelegramSendDto dto) {
        return service.sendMessage(dto);
    }

    @GetMapping("/updates")
    public TelegramRequestRoot updates() {
        return service.getUpdateService();
    }


    @GetMapping("/send-message")
    public String send() {
        service.set();
        return "Sent";
    }
}
