package com.ricarrdev.todolist.service;

import com.ricarrdev.todolist.domain.Users.UserType;
import com.ricarrdev.todolist.domain.Users.Users;
import com.ricarrdev.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTask(Users creator) throws Exception {
        if(creator.getUserType() == UserType.ADMIN) {
            throw new Exception("Administradores não podem criar tarefas! ");
        }
        if(creator.getUserType() == UserType.COMMON && creator.getTasks().size() >= 20) {
            throw new Exception("Usuário atingiu o limite máximo de 20 tarefas!");
        }
    }

    public void save(Users usuario) {
        this.userRepository.save(usuario);
    }

    public List<Users> findAll() throws Exception {
        List<Users> users = this.userRepository.findAll();
        if (users.isEmpty()) {
            throw new Exception("Nenhum usuário encontrado");
        }
        return users;
    }

    public Users findUserById(UUID id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public Users findUserByDocumento(String documento) throws Exception {
        return this.userRepository.findUserByDocumento(documento).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void delete(UUID id) {
        this.userRepository.deleteById(id);
    }
}