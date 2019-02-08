package com.Bookstore.demo.util;

import org.springframework.stereotype.Service;

@Service
public class TextUtil {

    // ======================================
    // =          Business methods          =
    // ======================================

    public String sanitize(String textToSanitize) {
        return textToSanitize.replaceAll("\\s+", " ");
    }
}
