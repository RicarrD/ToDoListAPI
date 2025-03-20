package com.ricarrdev.todolist.repository;

import com.ricarrdev.todolist.domain.Tasks.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Tasks, UUID> {
}