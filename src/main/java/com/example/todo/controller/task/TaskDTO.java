package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;

import java.text.SimpleDateFormat;

public record TaskDTO (
    long id,
    String summary,
    String description,
    String status,
    String dayLimit
) {
    public static  TaskDTO toDTO(TaskEntity entity) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return new TaskDTO(
                entity.id(),
                entity.summary(),
                entity.description(),
                entity.status().name(),
                date.format(entity.dayLimit())
        );
    }
}
