package com.ricarrdev.todolist.service;

import com.ricarrdev.todolist.domain.Tasks.Tasks;
import com.ricarrdev.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> findAll() {
        return taskRepository.findAll();
    }

    public Tasks findTaskById(UUID id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() -> new Exception("Task não encontrada"));
    }

    public void delete(UUID id) {
        this.taskRepository.deleteById(id);
    }
}