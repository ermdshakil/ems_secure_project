package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.Salary;

public interface SalaryRepo extends JpaRepository<Salary, Long> {
	List<Salary> findByEmployee_employeeId(Long employeeId);

}
