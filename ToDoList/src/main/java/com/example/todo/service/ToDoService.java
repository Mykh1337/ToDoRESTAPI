package com.example.todo.service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> getAll() {
        return repository.findAll();
    }

    public List<ToDo> getByCompleted(boolean completed) {
        return repository.findByCompleted(completed);
    }

    public ToDo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ToDo create(ToDo todo) {
        return repository.save(todo);
    }

    public ToDo update(Long id, ToDo todo) {
        todo.setId(id);
        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
