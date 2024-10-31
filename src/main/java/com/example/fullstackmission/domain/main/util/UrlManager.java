package com.example.fullstackmission.domain.main.util;

import org.springframework.stereotype.Component;

@Component
public class UrlManager {
    private static final String MAIN = "/books/%d/notes/%d";

    public static String redirectMain(long bookId, long noteId) {
        return "redirect:" + MAIN.formatted(bookId, noteId);
    }

}
