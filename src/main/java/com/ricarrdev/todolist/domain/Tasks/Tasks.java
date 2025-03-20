package com.ricarrdev.todolist.domain.Tasks;

import com.ricarrdev.todolist.domain.entity.Users;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="tasks")
@Table(name="tasks")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Users usuario;
}
