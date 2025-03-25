package com.ricarrdev.todolist.controller;

import com.ricarrdev.todolist.domain.Tasks.Task;
import com.ricarrdev.todolist.dtos.TaskDTO;
import com.ricarrdev.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> save(TaskDTO task) {
        this.taskService.save(task);
        return task;
    }
}
