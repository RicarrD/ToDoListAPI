package com.ricarrdev.todolist.dtos;

import java.util.UUID;

public record TaskDTO(String titulo, String descricao, UUID usuario_id) {
}
