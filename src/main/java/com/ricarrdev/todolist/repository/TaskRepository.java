package com.ricarrdev.todolist.repository;

import com.ricarrdev.todolist.domain.Tasks.TaskStatus;
import com.ricarrdev.todolist.domain.Tasks.TaskDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskDTO, UUID> {
    Optional<TaskDTO> findTasksById(UUID id);
    List<TaskDTO> findTasksByTaskStatus(TaskStatus taskStatus);
}