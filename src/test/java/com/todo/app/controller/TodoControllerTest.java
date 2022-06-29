package com.todo.app.controller;

import com.todo.app.controller.TodoController;
import com.todo.app.controller.dto.TodoDto;
import com.todo.app.entity.Todo;
import com.todo.app.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class TodoControllerTest {
    private TodoController todoController;
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        todoRepository = mock(TodoRepository.class);
        todoController = new TodoController(todoRepository);
    }

    @Test
    void shouldCreateTodo() {
        TodoDto todoDto = TodoDto.builder().name("Read Java").dueDate(OffsetDateTime.now()).build();

        Todo todo = new Todo(todoDto);

        when(todoRepository.save(any())).thenReturn(todo);

        ResponseEntity<Object> response = todoController.createTodo(todoDto);

        verify(todoRepository).save(todo);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void shouldReturnTodos() {

        todoController.getTodos();

        verify(todoRepository).findAll();
    }

    @Test
    void shouldReturnTodo() {
        when(todoRepository.findById(1L)).thenReturn(Optional.of(mock(Todo.class)));
        todoController.getTodoBy(1);

        verify(todoRepository).findById(1L);
    }

    @Test
    void shouldReturn404WhenTodoNotFound() {

        ResponseEntity<Object> response = todoController.getTodoBy(1);

        verify(todoRepository).findById(1L);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void shouldDeleteTodo() {
        todoController.deleteTodoBy(1);
        verify(todoRepository).deleteById(1L);
    }
}