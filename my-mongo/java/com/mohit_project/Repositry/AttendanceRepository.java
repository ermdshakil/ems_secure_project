//package com.mohit_project.Repositry;
//
//import com.mohit_project.Entity.Attendance;
//import com.mohit_project.Entity.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
//    List<Attendance> findByEmployee(Employee employee);
//
//    
//    List<Attendance> findByEmployee_employeeId( Long employeeId);
//}