package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mohit_project.Entity.EmAttendance;

public interface EmAttendanceRepo extends JpaRepository<EmAttendance, Long>{
	List<EmAttendance> findByEmployeel_employeeId(Long employeelId);

}
