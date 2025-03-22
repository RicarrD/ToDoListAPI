package com.ricarrdev.todolist.domain.Tasks;

import com.ricarrdev.todolist.domain.Users.Users;
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
public class TaskDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    private LocalDateTime dataConclusao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Users usuario;
}
