package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.KycUpdate;

public interface KycUpdateRepo extends JpaRepository<KycUpdate, Long> {
	List<KycUpdate> findByEmployeeId(Long employeeId);

}
