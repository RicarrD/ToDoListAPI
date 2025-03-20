package com.ricarrdev.todolist.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(unique=true)
    private String email;

    @Column(unique=true)
    private String documento;

    private String senha;
    private LocalDateTime dataRegistro;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
