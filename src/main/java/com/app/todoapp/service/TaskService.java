package com.app.todoapp.service;


import com.app.todoapp.entity.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTasks(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No task present with id " + id));
        taskRepository.delete(task);
    }

    public void toggleTask(Long id) {
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No task present with id"+id));
        task.setCompleted(!task.getCompleted());
        taskRepository.save(task);
    }
}
