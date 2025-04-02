package com.example.task.repository;

import com.example.task.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    Optional<Task> findById(int taskId);
    List<Task> findByStatus(String taskStatus);
    void deleteById(int taskId);
    Task saveOrUpdate(Task task);
}