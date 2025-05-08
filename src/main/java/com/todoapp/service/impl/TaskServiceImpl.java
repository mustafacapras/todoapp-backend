package com.todoapp.service.impl;

import com.todoapp.dto.TaskRequest;
import com.todoapp.model.Task;
import com.todoapp.repository.TaskRepository;
import com.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(TaskRequest taskRequest, Long userId) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setPriority(taskRequest.getPriority());
        task.setStatus(taskRequest.getStatus());
        task.setCategory(taskRequest.getCategory());
        task.setVital(taskRequest.isVital());
        task.setUserId(userId);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, TaskRequest taskRequest, Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUserId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setPriority(taskRequest.getPriority());
        task.setStatus(taskRequest.getStatus());
        task.setCategory(taskRequest.getCategory());
        task.setVital(taskRequest.isVital());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUserId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        taskRepository.delete(task);
    }

    @Override
    public Task getTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUserId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        return task;
    }

    @Override
    public List<Task> getAllTasks(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public List<Task> getVitalTasks(Long userId) {
        return taskRepository.findByUserIdAndIsVital(userId, true);
    }

    @Override
    public List<Task> getTasksByCategory(String category, Long userId) {
        return taskRepository.findByUserIdAndCategory(userId, category);
    }

    @Override
    public List<Task> getTasksByStatus(String status, Long userId) {
        return taskRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<Task> getTasksByPriority(String priority, Long userId) {
        return taskRepository.findByUserIdAndPriority(userId, priority);
    }
} 