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
    public  List<TaskForm> toTaskFormList(){

        List<TaskForm> toTaskFormList = new ArrayList<>();

        for (int i=0; i < summary.size(); i++){
            if (!(summary.get(i).isEmpty() || !(status.get(i).equals("TODO") || status.get(i).equals("DOING") || status.get(i).equals("DONE")) || dayLimit.get(i).isEmpty())) {
                String newDescription = description.isEmpty() ? "" : description.get(i);
                TaskForm taskForm = new TaskForm(summary.get(i), newDescription, status.get(i), dayLimit.get(i));
                toTaskFormList.add(taskForm);
            }
        }
        return toTaskFormList;
    }
}
