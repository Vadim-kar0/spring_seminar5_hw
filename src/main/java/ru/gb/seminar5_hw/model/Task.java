package ru.gb.seminar5_hw.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity(name = "task")
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(name = "date_of_create")
    private String dateOfCreate;

    public Task() {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eeee d.MM.yy HH:mm:ss VV");
        this.status = TaskStatus.CREATED;
        this.dateOfCreate = dtf.format(ZonedDateTime.now());
    }

    public enum TaskStatus {
        CREATED, IN_PROGRESS, COMPLETED
    }


}
