package com.ricarrdev.todolist.service;

import com.ricarrdev.todolist.domain.Tasks.TaskStatus;
import com.ricarrdev.todolist.domain.Tasks.Task;
import com.ricarrdev.todolist.dtos.TaskDTO;
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

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    public Task findTaskById(UUID id) throws Exception {
        return this.taskRepository.findTasksById(id).orElseThrow(() -> new Exception("Task não encontrada"));
    }

    public List<Task> findTasksByTaskStatus(TaskStatus taskStatus) throws Exception {
        List<Task> tasks = this.taskRepository.findTasksByTaskStatus(taskStatus);
        if (tasks.isEmpty()) {
            throw new RuntimeException("Nenhuma tarefa encontrada com este status");
        } else {
         return tasks;
        }
    }

    public void delete(UUID id) {
        this.taskRepository.deleteById(id);
    }

    public void save(Task tasks) {
        this.taskRepository.save(tasks);
    }
}