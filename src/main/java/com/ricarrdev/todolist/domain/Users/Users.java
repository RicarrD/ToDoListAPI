package com.ricarrdev.todolist.domain.Users;

import com.ricarrdev.todolist.domain.Tasks.Tasks;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @Column(unique=true)
    private String email;

    @Column(unique=true)
    private String documento;

    private String senha;

    @CreationTimestamp
    private LocalDateTime dataRegistro;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tasks> tasks;
}
