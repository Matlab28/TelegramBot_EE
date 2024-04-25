package com.example.telegrambot.service;

import com.example.telegrambot.client.TelegramFeignClient;
import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramBotService {
    private final TelegramFeignClient feignClient;

    public TelegramRequestRoot getUpdateService() {
        TelegramRequestRoot updates = feignClient.getUpdates(0L);
        Integer updateId = updates.getResult().get(updates.getResult().size() - 1).getUpdateId();
        log.info("Message got from - ");
        return feignClient.getUpdates(Long.valueOf(updateId));
    }

    public TelegramResponseRoot sendMessage(TelegramSendDto dto) {
        return feignClient.sendMessage(dto);
    }


    @Scheduled(fixedDelay = 5000)
    public void set() {
        TelegramRequestRoot updateService = getUpdateService();
        String text = updateService.getResult().get(0).getMessage().getText();
        Long id = updateService.getResult().get(0).getMessage().getChat().getId();
        TelegramSendDto dto = new TelegramSendDto();
        dto.setChatId(String.valueOf(id));

        if (text.equals("/start")) {
            String msg = "Hi " + updateService.getResult().get(0).getMessage().getFrom().getFirstName() +
                    "!\nHow can I help you?";
            dto.setText(msg);
            sendMessage(dto);
        }
    }
}
