package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record TaskFormX(
    List<String> summary,
    List<String> description,
    List<String> status,
    List<String> dayLimit
) {
    public List<List<String>> taskSeparate() {

        List<List<String>> tasks = new ArrayList<>();

        for (int i=0; i < summary.size(); i++){
            List<String> task = new ArrayList<>();
            task.add(summary.get(i) != null ? summary.get(i) : "");
            task.add(description.get(i) != null ? description.get(i) : "");
            task.add(status.get(i) != null ? status.get(i) : "TODO");
            task.add(dayLimit.get(i) != null ? dayLimit.get(i) : "2000/01/01");

            tasks.add(task);
        }
        return tasks;
    }
}
