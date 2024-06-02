package com.example.telegrambot.client;

import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "telegramApi", url = "https://api.telegram.org/botYOUR_BOT_TOKEN")
public interface TelegramFeignClient {

//    @GetMapping("/getUpdates?offset={value}")
//    TelegramRequestRoot getUpdates(@PathVariable Long value);

    @GetMapping("/getUpdates")
    TelegramRequestRoot getUpdates(@RequestParam("offset") Long value);


    @PostMapping("/sendMessage")
    TelegramResponseRoot sendMessage(@RequestBody TelegramSendDto dto);
}

