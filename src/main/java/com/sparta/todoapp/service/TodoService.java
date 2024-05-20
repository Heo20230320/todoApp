package com.sparta.todoapp.service;

import com.sparta.todoapp.controller.TodoRequestDTO;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    // 할일 생성
    public Todo createTodo(TodoRequestDTO dto) {

        var newTodo = dto.toEntity();
        Todo result = todoRepository.save(newTodo);
        return result;
    }

    // 할일 단건 조회
    public Todo getTodo(Long todoId) {
        return todoRepository.findById(todoId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
