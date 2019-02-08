package com.Bookstore.demo.util;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface NumberGenerator {

    // ======================================
    // =          Business methods          =
    // ======================================

    String generateNumber();
    public String sanitize(String textToSanitize);
}
