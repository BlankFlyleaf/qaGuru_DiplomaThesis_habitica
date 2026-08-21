package com.habitica.api.models.tasks;

import java.util.List;

public record TaskBaseBodyModel(String type,
                                String text,
                                String notes,
                                double priority,
                                List<String> tags) {
}
