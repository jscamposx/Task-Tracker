package com.example.task.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.task.exceptions.TaskStorageException;
import com.example.task.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Repository
public class FileTaskRepository implements TaskRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Path filePath = Paths.get(
            System.getProperty("user.home"),
            ".task_tracker",
            "data",
            "tasks.json"
    );
    private final ReentrantLock lock = new ReentrantLock();
    private List<Task> tasks = new ArrayList<>();

    @PostConstruct
    public void init() {
        loadTasksFromFile();
    }

    @Override
    public Task saveOrUpdate(Task task) {
        lock.lock();
        try {
            Optional<Task> existingTask = findById(task.getTaskID());
            if (existingTask.isPresent()) {
                Task taskToUpdate = existingTask.get();
                taskToUpdate.setTaskDescription(task.getTaskDescription());
                taskToUpdate.setTaskStatus(task.getTaskStatus().toUpperCase());
                taskToUpdate.setTaskCreateAt(LocalDateTime.now().toString());
            } else {
                task.setTaskCreateAt(LocalDateTime.now().toString());
                tasks.add(task);
            }
            saveTasksToFile();
            return task;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Task save(Task task) {
        lock.lock();
        try {
            int newTaskId = generateNextTaskId();
            task.setTaskID(newTaskId);
            task.setTaskCreateAt(LocalDateTime.now().toString());
            tasks.add(task);
            saveTasksToFile();
            return task;
        } finally {
            lock.unlock();
        }
    }

    private int generateNextTaskId() {
        return tasks.stream()
                .mapToInt(Task::getTaskID)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Optional<Task> findById(int taskId) {
        return tasks.stream()
                .filter(task -> task.getTaskID() == taskId)
                .findFirst();
    }

    @Override
    public List<Task> findByStatus(String taskStatus) {
        return tasks.stream()
                .filter(task -> task.getTaskStatus().equals(taskStatus))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(int taskId) {
        lock.lock();
        try {
            boolean removed = tasks.removeIf(task -> task.getTaskID() == taskId);
            if (removed) {
                saveTasksToFile();
            }
        } finally {
            lock.unlock();
        }
    }

    private void loadTasksFromFile() {
        lock.lock();
        try {
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
                tasks = new ArrayList<>();
                saveTasksToFile();
            } else {
                byte[] jsonData = Files.readAllBytes(filePath);
                if (jsonData.length > 0) {
                    tasks = objectMapper.readValue(jsonData, new TypeReference<List<Task>>() {});
                } else {
                    tasks = new ArrayList<>();
                }
            }
        } catch (IOException e) {
            throw new TaskStorageException("Error cargando tareas", e);
        } finally {
            lock.unlock();
        }
    }

    private void saveTasksToFile() {
        try {
        
            String json = objectMapper.writeValueAsString(tasks);
            Files.write(filePath, json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new TaskStorageException("Error guardando tareas", e);
        }
    }

}
