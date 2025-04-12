package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.LeaveRequst;




public interface LeaveRequstRepo extends JpaRepository<LeaveRequst, Long> {
	List<LeaveRequst> findByEmployee_employeeId(Long employeeId);

}
