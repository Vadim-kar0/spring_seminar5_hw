package ru.gb.seminar5_hw.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.seminar5_hw.model.Task;
import ru.gb.seminar5_hw.model.Task.TaskStatus;
import ru.gb.seminar5_hw.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService service;

    @GetMapping()
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.createTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id,@RequestBody Task task){
        return service.updateStatusOfTask(id,task.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }











}
