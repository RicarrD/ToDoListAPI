package com.ricarrdev.todolist.controller;

import com.ricarrdev.todolist.domain.Tasks.Task;
import com.ricarrdev.todolist.dtos.TaskDTO;
import com.ricarrdev.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody TaskDTO task) {
        Task newTask = this.taskService.save(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = this.taskService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // create a method to done task
    // implement delete task
    // implement all the methods in service
}
