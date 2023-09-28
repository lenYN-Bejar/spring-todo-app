package com.TodoApp.TodoApp.Controller;

import com.TodoApp.TodoApp.Models.Task;
import com.TodoApp.TodoApp.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping("/tasks")
    public List<Task> getTasks () {
        return todoRepository.findAll();
    }

    @PostMapping("/tasks")
    public String saveTasks (@RequestBody Task task) {
        todoRepository.save(task);
        return "Save Task";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask (@RequestBody Task task, @PathVariable long id) {
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        todoRepository.save(updateTask);
        return "Updated Task";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask (@PathVariable long id) {
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "Delete Task";
    }
}
