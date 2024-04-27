package ru.gb.seminar5_hw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.gb.seminar5_hw.model.Task;
import ru.gb.seminar5_hw.model.Task.TaskStatus;
import ru.gb.seminar5_hw.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
@Log
public class TaskController {
    private final TaskService service;

    @GetMapping()
    public List<Task> getAllTasks(){
        log.info("\nUsing getAllTasks: \n" + service.getAllTasks()
                .toString()
                .replaceAll("\\), ", "), \n"));
        return service.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        log.info("Task was created: " + task);
        return service.createTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        log.info("\nGet tasks by status: " + status +  ". \n" + service.getByStatus(status)
                .toString().replaceAll("\\), ", "), \n"));
        return service.getByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id,@RequestBody Task task){
        log.info("Task with id = " + id + " was updated: " + task);
        return service.updateStatusOfTask(id,task.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        log.info("Task was deleted: " + service.getTaskById(id));
        service.deleteTask(id);
    }











}
