package ru.gb.seminar5_hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gb.seminar5_hw.model.Task;
import ru.gb.seminar5_hw.model.Task.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);
    @Modifying
    @Query("UPDATE task SET status = :status WHERE id = :id")
    void changeStatus(long id, TaskStatus status);
}
