package com.ricarrdev.todolist.controller;

import com.ricarrdev.todolist.domain.Tasks.Task;
import com.ricarrdev.todolist.domain.Tasks.TaskStatus;
import com.ricarrdev.todolist.dtos.TaskDTO;
import com.ricarrdev.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable UUID id) throws Exception {
        Task tasks = this.taskService.findTaskById(id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> findTasksByTaskStatus(@RequestParam TaskStatus status) throws Exception {
        List<Task> tasks = this.taskService.findTasksByTaskStatus(status);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) throws Exception {
        taskService.findTaskById(id);
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
