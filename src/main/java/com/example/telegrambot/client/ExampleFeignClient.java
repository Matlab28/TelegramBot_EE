package com.example.telegrambot.client;

import com.example.telegrambot.dto.request.MessageRequestDto;
import com.example.telegrambot.dto.telegram.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telegram", url = "https://api.telegram.org/bot6627982719:AAHlTAMMWAJmUr-8rDe4N_z0whUsloFdiwk")
public interface ExampleFeignClient {

    @GetMapping("/getUpdates")
    Root getUpdates();

    @PostMapping("/sendMessage")
    void sendMessage(@RequestBody MessageRequestDto dto);
}

