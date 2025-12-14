package com.app.todoapp.repository;

import com.app.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

interface taskRepository extends JpaRepository<Task,Long> {
}
