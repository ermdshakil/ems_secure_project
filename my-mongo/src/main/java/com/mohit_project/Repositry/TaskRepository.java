package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEmployeeId(String employeeId);
}

