package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.RAttendance;

public interface RAttendanceRepo extends JpaRepository<RAttendance, Long>{
	List<RAttendance> findByEmployeeId(Long employeeId);

}
