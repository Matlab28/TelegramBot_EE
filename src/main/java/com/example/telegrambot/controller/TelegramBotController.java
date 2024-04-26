package com.example.telegrambot.controller;

import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import com.example.telegrambot.service.TelegramBotService;
import com.example.telegrambot.service.TelegramService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
//@RequestMapping("/api")
public class TelegramBotController {
    private final TelegramService service;

//    @GetMapping("/send-message")
//    public String sendMessage() {
//        service.set();
//        log.info("Message sent");
//        return "Success!";
//    }

//    @GetMapping("/updates")
//    public TelegramRequestRoot updates() {
//        return service.getUpdateService();
//    }

//    @PostMapping("/send")
//    public TelegramResponseRoot sendMessage(@RequestBody TelegramSendDto dto) {
//        return service.sendMessage(dto);
//    }

}
