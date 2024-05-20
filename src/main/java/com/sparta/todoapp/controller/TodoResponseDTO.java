package com.sparta.todoapp.controller;

import com.sparta.todoapp.repository.Todo;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter

public class TodoResponseDTO {
    private TodoRequestDTO todoRequestDTO;

    private String title;

    private String content;

    private String userName;

    private LocalDateTime createdAt;

    public TodoResponseDTO(Todo todo) {
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.userName = todo.getUserName();
        this.createdAt = todo.getCreatedAt();

    }
}
