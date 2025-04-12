package com.mohit_project.Repositry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.Attendaces;

public interface AttendacesRepo extends JpaRepository<Attendaces, Long> {
	List<Attendaces> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);

}
