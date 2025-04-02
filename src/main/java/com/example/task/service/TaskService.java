package com.example.task.service;

import com.example.task.exceptions.TaskStorageException;
import com.example.task.model.Task;
import com.example.task.repository.FileTaskRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final FileTaskRepository taskRepository;

    public TaskService(FileTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String description) {
        Task newTask = new Task(description, "TODO", getCurrentTimestamp());
        return taskRepository.save(newTask);
    }

    public Task updateTask(int taskId, String newDescription, String newStatus) {
        Task existingTask = findTaskById(taskId);
        existingTask.setTaskDescription(newDescription);
        existingTask.setTaskStatus(newStatus);
        existingTask.setTaskCreateAt(getCurrentTimestamp());
        return taskRepository.saveOrUpdate(existingTask);
    }

    public void deleteTask(int taskId) {
        findTaskById(taskId);
        taskRepository.deleteById(taskId);
    }

    public String getFormattedTaskListDone() {
        List<Task> doneTasks = taskRepository.findByStatus("DONE");
        return formatTaskListOutput(doneTasks);
    }

    public String getFormattedTaskListTODO() {
        List<Task> todoTasks = taskRepository.findByStatus("TODO");
        return formatTaskListOutput(todoTasks);
    }

    public String getFormattedTaskListAll() {
        List<Task> allTasks = taskRepository.findAll();
        return formatTaskListOutput(allTasks);
    }

    private Task findTaskById(int taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskStorageException("Tarea no encontrada con ID: " + taskId));
    }

    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    private String formatTaskListOutput(List<Task> tasks) {
        if (tasks.isEmpty()) {
            return "No hay tareas.";
        }
        return "\n📋 Lista de Tareas:\n" +
                tasks.stream()
                        .map(this::formatTaskDetails)
                        .collect(Collectors.joining("\n"));
    }

    private String formatTaskDetails(Task task) {
        return String.format("🔹 [%d] %s - %s - %s",
                task.getTaskID(),
                task.getTaskDescription(),
                task.getTaskStatus(),
                task.getTaskCreateAt());
    }
}