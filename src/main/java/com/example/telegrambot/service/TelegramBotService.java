package com.example.telegrambot.service;

import com.example.telegrambot.client.ExampleFeignClient;
import com.example.telegrambot.dto.request.MessageRequestDto;
import com.example.telegrambot.dto.telegram.Result;
import com.example.telegrambot.dto.telegram.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramBotService {
    private final ExampleFeignClient feignClient;

    @Scheduled(fixedDelay = 1000)
    public void getUpdates() {
        Root updates = feignClient.getUpdates();

        for (Result result : updates.getResult()) {
            if (result.getMessage().getText().toLowerCase().contains("hello")) {
                String text = "Hello " + result.getMessage().getChat().getFirst_name();



            }
        }
    }

    public void sendMessage(MessageRequestDto messageRequestDto){
        feignClient.sendMessage(messageRequestDto);

    }
}
