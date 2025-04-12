package com.mohit_project.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.EmAttendance;
import com.mohit_project.Entity.Employee;
import com.mohit_project.Repositry.EmAttendanceRepo;
import com.mohit_project.Repositry.EmployeeRepo;


@Service
public class EmAttendanceService {
    @Autowired
    private EmAttendanceRepo attendanceRepository;
    
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmAttendance> getAttendanceByEmployeeId(Long employeeId) {
        return attendanceRepository.findByEmployeel_employeeId(employeeId);
    }
 
//    public EmAttendance punchIn(Employee employeel) {
//        EmAttendance attendance = new EmAttendance();
//        attendance.setEmployeel(employeel);
//        attendance.setPunchIn(LocalDateTime.now());
//        return attendanceRepository.save(attendance);
//    }
    public EmAttendance punchIn(EmAttendance emAttendance) {
        if (emAttendance.getEmployeel() != null) {
        	employeeRepo.save(emAttendance.getEmployeel()); // Ensure employee is saved
        }
        emAttendance.setPunchIn(LocalDateTime.now());
        return attendanceRepository.save(emAttendance);
    }


    public EmAttendance punchOut(Long attendanceId) {
        Optional<EmAttendance> attendanceOpt = attendanceRepository.findById(attendanceId);
        if (attendanceOpt.isPresent()) {
            EmAttendance attendance = attendanceOpt.get();
            attendance.setPunchOut(LocalDateTime.now());
            return attendanceRepository.save(attendance);
        }
        return null;
    }
}

