package com.ricarrdev.todolist.domain.Tasks;

import com.ricarrdev.todolist.dtos.TaskDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="tasks")
@Table(name="tasks")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    private LocalDateTime dataConclusao;

    public Task(TaskDTO data) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.taskStatus = data.taskStatus();
        this.dataCriacao = data.dataCriacao();
    }
}
