package com.example.task.cli;

import com.example.task.service.TaskService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class TaskCommands {

	private final TaskService taskService;

	public TaskCommands(TaskService taskService) {
		this.taskService = taskService;
	}

	@ShellMethod(key = "add", value = "Añade una nueva tarea")
	public String addTask(@ShellOption(help = "Descripción de la tarea") String description) {
		try {
			taskService.createTask(description);
			return "✅ Tarea añadida correctamente: " + description;
		} catch (Exception e) {
			return "❌ Error al añadir la tarea: " + e.getMessage();
		}
	}

	@ShellMethod(key = "list", value = "Muestra la lista de todas las tareas")
	public String listTasks() {
		try {
			return taskService.getFormattedTaskListAll();
		} catch (Exception e) {
			return "❌ Error al obtener la lista de tareas: " + e.getMessage();
		}
	}

	@ShellMethod(key = "list-done", value = "Muestra la lista de tareas completadas")
	public String listDoneTasks() {
		try {
			return taskService.getFormattedTaskListDone();
		} catch (Exception e) {
			return "❌ Error al obtener la lista de tareas completadas: " + e.getMessage();
		}
	}

	@ShellMethod(key = "list-todo", value = "Muestra la lista de tareas pendientes")
	public String listTodoTasks() {
		try {
			return taskService.getFormattedTaskListTODO();
		} catch (Exception e) {
			return "❌ Error al obtener la lista de tareas pendientes: " + e.getMessage();
		}
	}

	@ShellMethod(key = "delete", value = "Elimina una tarea por su ID")
	public String deleteTask(@ShellOption(help = "ID de la tarea a eliminar") int id) {
		try {
			taskService.deleteTask(id);
			return "✅ Tarea eliminada correctamente con ID: " + id;
		} catch (Exception e) {
			return "❌ Error al eliminar la tarea con ID " + id + ": " + e.getMessage();
		}
	}

	@ShellMethod(key = "update", value = "Actualiza una tarea existente")
	public String updateTask(
			@ShellOption(help = "ID de la tarea a actualizar") int id,
			@ShellOption(help = "Nueva descripción de la tarea") String newDescription,
			@ShellOption(help = "Nuevo estado de la tarea") String newStatus) {
		try {
			taskService.updateTask(id, newDescription, newStatus);
			return "✅ Tarea actualizada correctamente con ID: " + id;
		} catch (Exception e) {
			return "❌ Error al actualizar la tarea con ID " + id + ": " + e.getMessage();
		}
	}
}