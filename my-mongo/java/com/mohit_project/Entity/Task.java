package com.mohit_project.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;
    private String taskTitle;
    @Column(columnDefinition = "TEXT",length = 1000)
    private String taskAbout;
    private String employeeId;
    private String name;
    private String status;
    private LocalDate assign;
    private LocalDateTime complet;

    // Getters and setters
}
