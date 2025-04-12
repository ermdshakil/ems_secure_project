package com.mohit_project.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.RAttendance;
import com.mohit_project.Repositry.RAttendanceRepo;

@Service
public class RAttendanceService {
	
	
	@Autowired
	private RAttendanceRepo rAttendanceRepo;
	
	 public RAttendance punchIn(Long employeeId, String selfiePath, String latitude, String longitude) {
//		 RAttendance attendance = new RAttendance(employeeId, LocalDateTime.now(), selfiePath, latitude, longitude);
		 RAttendance attendance = new RAttendance();
	        attendance.setEmployeeId(employeeId);
	        attendance.setLatitude(latitude);
	        attendance.setLongitude(longitude);
	        attendance.setSelfiePath(selfiePath);
	        attendance.setPunchInTime(LocalDateTime.now()); // Set current time as punch-in time
		 
	        return rAttendanceRepo.save(attendance);
	    }
	 
	 public RAttendance punchOut(Long attendanceId) {
	        RAttendance attendance = rAttendanceRepo.findById(attendanceId).orElseThrow(() -> new RuntimeException("Attendance not found"));
	        attendance.setPunchOutTime(LocalDateTime.now()); // Set current time as punch-out time

	        return rAttendanceRepo.save(attendance); // Save the updated record
	    }
	 
	 public List<RAttendance> getAllRAttendanceByEmployeeId(Long employeeId){
		 return this.rAttendanceRepo.findByEmployeeId(employeeId);
	 }
}
