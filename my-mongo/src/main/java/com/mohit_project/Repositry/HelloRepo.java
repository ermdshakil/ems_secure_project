package com.mohit_project.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mohit_project.Entity.Hello;



@Repository
public interface HelloRepo extends JpaRepository<Hello, Long> {
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Present'")
	    long countPresentEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Absent'")
	    long countAbsentEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Late'")
	    long countLateEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Half Day'")
	    long countHalfDayEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Paid Leave'")
	    long countPaidLeaveEmployees();
	 
	 @Query("SELECT COUNT(h) FROM Hello h WHERE h.employeeId = :employeeId AND h.status = 'present' AND FUNCTION('MONTH', h.punchIn) = :month AND FUNCTION('YEAR', h.punchIn) = :year")
	    Long countPresentDays(@Param("employeeId") Long employeeId, @Param("month") int month, @Param("year") int year);

	    @Query("SELECT COUNT(h) FROM Hello h WHERE h.employeeId = :employeeId AND h.status = 'absent' AND FUNCTION('MONTH', h.punchIn) = :month AND FUNCTION('YEAR', h.punchIn) = :year")
	    Long countAbsentDays(@Param("employeeId") Long employeeId, @Param("month") int month, @Param("year") int year);

	    @Query("SELECT COUNT(h) FROM Hello h WHERE h.employeeId = :employeeId AND h.status = 'late' AND FUNCTION('MONTH', h.punchIn) = :month AND FUNCTION('YEAR', h.punchIn) = :year")
	    Long countLateDays(@Param("employeeId") Long employeeId, @Param("month") int month, @Param("year") int year);

	    @Query("SELECT COUNT(h) FROM Hello h WHERE h.employeeId = :employeeId AND h.status = 'half-day' AND FUNCTION('MONTH', h.punchIn) = :month AND FUNCTION('YEAR', h.punchIn) = :year")
	    Long countHalfDays(@Param("employeeId") Long employeeId, @Param("month") int month, @Param("year") int year);

	    @Query("SELECT COUNT(h) FROM Hello h WHERE h.employeeId = :employeeId AND h.status = 'paid-leave' AND FUNCTION('MONTH', h.punchIn) = :month AND FUNCTION('YEAR', h.punchIn) = :year")
	    Long countPaidLeaveDays(@Param("employeeId") Long employeeId, @Param("month") int month, @Param("year") int year);
	    
	    List<Hello> findByEmployeeId(Long employeeId);


}
