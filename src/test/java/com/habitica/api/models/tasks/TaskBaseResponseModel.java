package com.habitica.api.models.tasks;

public record TaskBaseResponseModel(
        boolean success,
        TaskData data,
        int userV,
        String appVersion
) {
}
