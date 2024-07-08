package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record TaskFormX(
    @NotBlank
    @Size(max = 256, message = "256文字以内で入力してください")
    String summary,
    String description,
    @NotBlank
    @Pattern(regexp="TODO|DOING|DONE", message = "Todo, Doing, Done のいずれかを選択してください")
    String status,
    @Pattern(regexp="\\d{4}/\\d{2}/\\d{2}", message = "yyyy/MM/ddの形式で入力してください")
    String dayLimit
) {
    public static TaskFormX formEntity(TaskEntity taskEntity) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return new TaskFormX(
            taskEntity.summary(),
            taskEntity.description(),
            taskEntity.status().name(),
            date.format(taskEntity.dayLimit())
        );
    }

    @SneakyThrows
    public TaskEntity toEntity() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(dayLimit());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new TaskEntity(null, summary(), description(), TaskStatus.valueOf(status()), date);
    }

    @SneakyThrows
    public TaskEntity toEntity(long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(dayLimit());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new TaskEntity(id, summary(), description(), TaskStatus.valueOf(status()), date);
    }
}
