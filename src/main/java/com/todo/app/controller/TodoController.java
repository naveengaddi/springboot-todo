package com.todo.app.controller;

import com.todo.app.controller.dto.TodoDto;
import com.todo.app.entity.Todo;
import com.todo.app.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/todos")
    public ResponseEntity<Object> createTodo(@RequestBody TodoDto todoDto) {
        log.info("Request for creating todo with details {}", todoDto.toString());
        Todo todo = new Todo(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        long id = savedTodo.getId();
        return ResponseEntity.created(URI.create("/todos/" + id)).build();
    }

    @GetMapping("/todos")
    public ResponseEntity<Object> getTodos() {
        log.info("Request for get all todos");
        Iterable<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok().body(todos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Object> getTodoBy(@PathVariable("id") long id) {
        log.info("Request for get todo with id {}", id);
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(todoOptional.get());
        }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Object> deleteTodoBy(@PathVariable("id") long id) {
        log.info("Request for deleting todo with id {}", id);
        todoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
