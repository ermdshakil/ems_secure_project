package com.mohit_project.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.EmployeeByDocument;

public interface EmployeeByDocumentRepo extends JpaRepository<EmployeeByDocument, Long> {
	 Optional<EmployeeByDocument> findByEmployee_employeeId(Long employeeId);

}
