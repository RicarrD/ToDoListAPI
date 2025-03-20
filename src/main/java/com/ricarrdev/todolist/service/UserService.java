package com.ricarrdev.todolist.service;

import com.ricarrdev.todolist.domain.entity.Users;
import com.ricarrdev.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(Users usuario) {
        return userRepository.save(usuario);
    }

    public List<Users> buscarTodosUsuarios() {
        return userRepository.findAll();
    }

    public Optional<Users> buscarUsuarioPorId(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}