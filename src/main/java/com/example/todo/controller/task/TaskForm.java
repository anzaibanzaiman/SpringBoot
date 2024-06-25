package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public record TaskForm(
    @NotBlank
    @Size(max = 256, message = "256文字以内で入力してください")
    String summary,
    String description,
    @NotBlank
    @Pattern(regexp="TODO|DOING|DONE", message = "Todo, Doing, Done のいずれかを選択してください")
    String status,
    String dayLimit
) {
    public static TaskForm formEntity(TaskEntity taskEntity) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return new TaskForm(
            taskEntity.summary(),
            taskEntity.description(),
            taskEntity.status().name(),
            date.format(taskEntity.dayLimit())
        );
    }

    @SneakyThrows
    public TaskEntity toEntity() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(dayLimit());
        return new TaskEntity(null, summary(), description(), TaskStatus.valueOf(status()), date);
    }

    @SneakyThrows
    public TaskEntity toEntity(long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(dayLimit());
        return new TaskEntity(id, summary(), description(), TaskStatus.valueOf(status()), date);
    }
}
