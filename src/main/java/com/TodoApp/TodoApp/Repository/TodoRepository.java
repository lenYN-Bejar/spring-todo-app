package com.TodoApp.TodoApp.Repository;

import com.TodoApp.TodoApp.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
}
