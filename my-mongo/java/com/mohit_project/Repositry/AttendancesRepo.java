package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.Attendances;

public interface AttendancesRepo extends JpaRepository<Attendances, Long> {
	;
	 List<Attendances> findByEmployee_employeeId(Long employeeId);
	

}
