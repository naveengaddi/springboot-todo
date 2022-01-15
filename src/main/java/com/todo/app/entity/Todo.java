package com.todo.app.entity;

import com.todo.app.controller.dto.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date dueDate;

    public Todo(TodoDto todoDto) {
        this.name = todoDto.getName();
        this.dueDate = Date.from(todoDto.getDueDate().toInstant());
    }
}
