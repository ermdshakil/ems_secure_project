package com.mohit_project.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Attendances;
import com.mohit_project.Entity.Employee;
import com.mohit_project.Repositry.AttendancesRepo;
import com.mohit_project.Repositry.EmployeeRepo;

@Service
public class AttendancesService {

    @Autowired
    private AttendancesRepo attendanceRepository;

    @Autowired
    private EmployeeRepo employeeRepository;
    
    public List<Attendances> getAllAttendances(){
    	return this.attendanceRepository.findAll();
    }
//    public Attendances punchIn(Employee employee) {
//    	Attendances attendances=new Attendances();
//    	attendances.setEmployee(employee);
//    	attendances.setPunchInTime(LocalDateTime.now());
//    	return attendanceRepository.save(attendances);
//    }
//    public Attendances punchOut(Long id) {
//    	  Optional<Attendances> attendanceOpt = attendanceRepository.findById(id);
//          if (attendanceOpt.isPresent()) {
//              Attendances attendance = attendanceOpt.get();
//              attendance.setPunchOutTime(LocalDateTime.now());
//              return attendanceRepository.save(attendance);
//          }
//          return null;
//      
//    }
    public Long punchIn(Long employeeId) {
        try {
            // Check if Employee exists
            Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

            Attendances record = new Attendances();
            record.setEmployee(employee);
            record.setPunchInTime(LocalDateTime.now());
            attendanceRepository.save(record);
            return record.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to punch in: " + e.getMessage());
        }
    }

//    public Attendances punchOut(Long attendanceId) {
//        Optional<Attendances> attendanceOpt = attendanceRepository.findById(attendanceId);
//        if (attendanceOpt.isPresent()) {
//            Attendances attendance = attendanceOpt.get();
//            attendance.setPunchOutTime(LocalDateTime.now());
//            // If timer is provided, use it; otherwise, calculate it
//          if (timer != null) {
//              attendance.setTimer(timer);
//          } else {
//              long secondsElapsed = Duration.between(attendance.getPunchIn(), attendance.getPunchOut()).getSeconds();
//              attendance.setTimer((int) secondsElapsed);
//          }
//            
//            return attendanceRepository.save(attendance);
//        }
//        return null;
//    }
    public Attendances punchOut(Long attendanceId, Integer timer) {
        Optional<Attendances> attendanceOpt = attendanceRepository.findById(attendanceId);
        if (attendanceOpt.isPresent()) {
            Attendances attendance = attendanceOpt.get();
            attendance.setPunchOutTime(LocalDateTime.now());

            // If timer is provided, use it; otherwise, calculate it
            if (timer != null) {
                attendance.setTimer(timer);
            } else {
                LocalDateTime punchInTime = attendance.getPunchInTime();
                LocalDateTime punchOutTime = attendance.getPunchOutTime();

                if (punchInTime != null && punchOutTime != null) {
                    long secondsElapsed = Duration.between(punchInTime, punchOutTime).getSeconds();
                    attendance.setTimer((int) secondsElapsed);
                } else {
                    throw new IllegalStateException("Punch-in or punch-out time is missing.");
                }
            }

            return attendanceRepository.save(attendance);
        } else {
            throw new IllegalArgumentException("Attendance record not found");
        }
    }
    // New method to get all attendances by employeeId
    public List<Attendances> getAttendancesByEmployeeId(Long employeeId) {
        return attendanceRepository.findByEmployee_employeeId(employeeId);
    }
}
