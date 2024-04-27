package ru.gb.seminar5_hw.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.seminar5_hw.exception.TaskNotFoundException;
import ru.gb.seminar5_hw.model.Task;
import ru.gb.seminar5_hw.model.Task.TaskStatus;
import ru.gb.seminar5_hw.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public List<Task> getAllTasks(){return repository.findAll();}

    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    public Task createTask(Task task) {return repository.save(task);}

    public Task updateStatusOfTask(Long id, TaskStatus status){
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        task.setStatus(status);
        return repository.save(task);
    }

    public void deleteTask(Long id){ repository.deleteById(id);}

    public List<Task> getByStatus(TaskStatus status){
        return repository.findAllByStatus(status);
    }

}
