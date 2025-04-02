package com.example.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private int taskID;
    private String taskDescription;
    private String taskStatus;
    private String taskCreateAt;

    public Task(String taskDescription, String taskStatus, String taskCreateAt) {
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskCreateAt = taskCreateAt;
    }
}