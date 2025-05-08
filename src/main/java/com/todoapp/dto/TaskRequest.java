package com.todoapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private LocalDateTime dueDate;

    @NotBlank
    private String priority;

    @NotBlank
    private String status;

    @NotBlank
    private String category;

    private boolean isVital;
} 