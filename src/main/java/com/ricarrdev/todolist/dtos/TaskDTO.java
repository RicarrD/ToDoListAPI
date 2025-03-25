package com.ricarrdev.todolist.dtos;

import com.ricarrdev.todolist.domain.Tasks.TaskStatus;

import java.time.LocalDateTime;

public record TaskDTO(String titulo, String descricao, TaskStatus taskStatus, LocalDateTime dataCriacao) {
    public TaskDTO {
        if (taskStatus == null) taskStatus = TaskStatus.PENDING;
        if (dataCriacao == null) dataCriacao = LocalDateTime.now();
    }
}
