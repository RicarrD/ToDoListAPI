package com.ricarrdev.todolist.repository;

import com.ricarrdev.todolist.domain.Tasks.TaskStatus;
import com.ricarrdev.todolist.domain.Tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    Optional<Task> findTasksById(UUID id);
    List<Task> findTasksByTaskStatus(TaskStatus taskStatus);
}