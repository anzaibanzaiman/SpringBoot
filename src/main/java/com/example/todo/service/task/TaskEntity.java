package com.example.todo.service.task;

import java.util.Date;

public record TaskEntity(
        Long id,
        String summary,
        String description,
        TaskStatus status,
        Date dayLimit
) {
}
