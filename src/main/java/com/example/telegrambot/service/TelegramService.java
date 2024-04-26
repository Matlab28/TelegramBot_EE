package com.example.telegrambot.service;

import com.example.telegrambot.client.TelegramFeignClient;
import com.example.telegrambot.dto.request.TelegramRequestRoot;
import com.example.telegrambot.dto.response.TelegramResponseRoot;
import com.example.telegrambot.dto.response.TelegramSendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramService {
    private final TelegramFeignClient feignClient;
    private final RestTemplate restTemplate;
    private final BookService service;

    @Value("book-finder1.p.rapidapi.com")
    private String rapidApiHost;

    @Value("674678e122mshd00ec5b8f945302p1052bcjsn0ad69ed2af91")
    private String rapidApiKey;

    public TelegramRequestRoot getUpdateService() {
        TelegramRequestRoot updates = feignClient.getUpdates(0L);
        Integer updateId = updates.getResult().get(updates.getResult().size() - 1).getUpdateId();
        log.info("Message got");
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
            log.info("Greetings sent");
        } else if (text.toLowerCase().contains("book")) {
            String apiUrl = "https://book-finder1.p.rapidapi.com/api/search?series=Wings%20of%20fire&book_type=Fiction&lexile_min=600&lexile_max=800&results_per_page=25&page=1";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Host", rapidApiHost);
            headers.set("X-RapidAPI-Key", rapidApiKey);

            HttpEntity<?> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, String.class);
            String responseBody = responseEntity.getBody();

            String formattedResponse = service.processBookResponse(responseBody);

            dto.setText(formattedResponse);

            sendMessage(dto);
            log.info("Book info sent");
        }
    }
}
