package com.habitica.api.models.login;

public record LoginDataItem(String id,
                            String apiToken,
                            boolean newUser,
                            String username) {
}
