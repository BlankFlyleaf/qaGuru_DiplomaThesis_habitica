package com.habitica.api.models.tasks;

import java.util.List;

public record TaskData(
        String id,
        String userId,
        String type,
        String text,
        String notes,
        List<String> tags,
        Double priority
) {
}