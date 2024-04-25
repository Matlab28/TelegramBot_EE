package com.example.telegrambot.client;

import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telegramApi", url = "https://api.telegram.org/bot6627982719:AAHlTAMMWAJmUr-8rDe4N_z0whUsloFdiwk")
public interface TelegramFeignClient {

    @GetMapping("/getUpdates?offset={value}")
    TelegramRequestRoot getUpdates(@PathVariable Long value);

    @PostMapping("/sendMessage")
    TelegramResponseRoot sendMessage(@RequestBody TelegramSendDto dto);
}

