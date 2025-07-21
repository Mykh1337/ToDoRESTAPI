package com.example.todo.controller;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ToDo> getAll(@RequestParam(required = false) Boolean completed) {
        if (completed != null) {
            return service.getByCompleted(completed);
        }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ToDo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo todo) {
        return service.create(todo);
    }

    @PutMapping("/{id}")
    public ToDo update(@PathVariable Long id, @RequestBody ToDo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
