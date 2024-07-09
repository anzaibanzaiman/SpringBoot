package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record TaskFormX(
    @NotEmpty
    List<String> summary,
    List<String> description,
    @NotEmpty
    List<String> status,
    @NotEmpty
    List<String> dayLimit
) {
    public List<List<String>> taskSeparate() {

        List<List<String>> tasks = new ArrayList<>();

        for (int i=0; i < summary.size(); i++){
            List<String> task = new ArrayList<>();
            task.add(summary.get(i));
            task.add(description.isEmpty() ? "" : description.get(i));
            task.add(status.get(i));
            task.add(dayLimit.get(i));

            tasks.add(task);
        }
        return tasks;
    }
}
