package com.example.telegrambot.service;

import com.example.telegrambot.dto.response.BookApiResponseDto.Book;
import com.example.telegrambot.dto.response.BookApiResponseDto.BookResponse;
import com.example.telegrambot.dto.response.BookApiResponseDto.PublishedWorks;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public String processBookResponse(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BookResponse bookResponse = objectMapper.readValue(jsonResponse, BookResponse.class);

            if (bookResponse.getTotalResults() > 0) {
                Book book = bookResponse.getResults().get(0);

                StringBuilder formattedMessage = new StringBuilder();
                formattedMessage.append("Title: ").append(book.getTitle()).append("\n");
                formattedMessage.append("Authors: ").append(String.join(", ", book.getAuthors())).append("\n");
                formattedMessage.append("Summary:\n").append(book.getSummary()).append("\n\n");

                List<PublishedWorks> publishedWorks = book.getPublishedWorks();
                if (publishedWorks != null && !publishedWorks.isEmpty()) {
                    formattedMessage.append("Published Works:\n");
                    for (PublishedWorks publishedWork : publishedWorks) {
                        formattedMessage.append("- ISBN: ").append(publishedWork.getIsbn())
                                .append(", Binding: ").append(publishedWork.getBinding()).append("\n");
                        formattedMessage.append("  - Copyright: ").append(publishedWork.getCopyright()).append("\n");
                        formattedMessage.append("  - Page Count: ").append(publishedWork.getPageCount()).append("\n");
                        formattedMessage.append("  - English Language Learner: ").append(publishedWork.getEnglishLanguageLearner()).append("\n");
                        formattedMessage.append("  - Published Work ID: ").append(publishedWork.getPublishedWorkId()).append("\n");
                        if (!StringUtils.isEmpty(publishedWork.getCoverArtUrl())) {
                            formattedMessage.append("  - Cover Art URL: ").append(publishedWork.getCoverArtUrl()).append("\n");
                        }
                    }
                }

                return formattedMessage.toString();
            } else {
                return "No book found.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while processing the book response.";
        }
    }
}

