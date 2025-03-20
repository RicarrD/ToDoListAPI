package com.ricarrdev.todolist.service;

import com.ricarrdev.todolist.domain.Tasks.Tasks;
import com.ricarrdev.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Tasks saveTarefa(Tasks tarefa) {
        return taskRepository.save(tarefa);  // Salva ou atualiza a tarefa
    }

    public List<Tasks> buscarTodasTarefas() {
        return taskRepository.findAll();  // Retorna todas as tarefas
    }

    public Optional<Tasks> buscarTarefaPorId(UUID id) {
        return taskRepository.findById(id);  // Retorna a tarefa pelo ID
    }

    public void deleteTarefa(UUID id) {
        taskRepository.deleteById(id);  // Deleta a tarefa pelo ID
    }
}