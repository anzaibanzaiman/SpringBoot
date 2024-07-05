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
    String summary0,
    String description0,
    @NotBlank
    @Pattern(regexp="TODO|DOING|DONE", message = "Todo, Doing, Done のいずれかを選択してください")
    String status0,
    @Pattern(regexp="\\d{4}/\\d{2}/\\d{2}", message = "yyyy/MM/ddの形式で入力してください")
    String dayLimit0
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
            date = sdf.parse(dayLimit0());
        } catch (ParseException ignored) {
        }
        return new TaskEntity(null, summary0(), description0(), TaskStatus.valueOf(status0()), date);
    }

    @SneakyThrows
    public TaskEntity toEntity(long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(dayLimit0());
        return new TaskEntity(id, summary0(), description0(), TaskStatus.valueOf(status0()), date);
    }
}
