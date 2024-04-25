package com.example.telegrambot.controller;

import com.example.telegrambot.client.ExampleFeignClient;
import com.example.telegrambot.dto.telegram.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TelegramBotController {
    private final ExampleFeignClient feignClient;

    @GetMapping("/telegram")
    public Root getUpdates() {
        return feignClient.getUpdates();
    }
}
