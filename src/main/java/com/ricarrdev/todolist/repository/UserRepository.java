package com.ricarrdev.todolist.repository;

import com.ricarrdev.todolist.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findUserByDocumento(String documento);
    Optional<Users> findUserByID(UUID id);
}