package com.todoapp.service;

import com.todoapp.dto.TaskRequest;
import com.todoapp.model.Task;
import java.util.List;

public interface TaskService {
    Task createTask(TaskRequest taskRequest, Long userId);
    Task updateTask(Long taskId, TaskRequest taskRequest, Long userId);
    void deleteTask(Long taskId, Long userId);
    Task getTask(Long taskId, Long userId);
    List<Task> getAllTasks(Long userId);
    List<Task> getVitalTasks(Long userId);
    List<Task> getTasksByCategory(String category, Long userId);
    List<Task> getTasksByStatus(String status, Long userId);
    List<Task> getTasksByPriority(String priority, Long userId);
} 