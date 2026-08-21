package com.habitica.api.models.login;

public record LoginErrorItem(String message,
                             String param,
                             String value) {
}
