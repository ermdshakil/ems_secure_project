package com.mohit_project.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Attendaces;
import com.mohit_project.Repositry.AttendacesRepo;

@Service
public class AttendcesService {
	 @Autowired
	    private AttendacesRepo attendanceRepository;

	    public List<Attendaces> getAttendanceForMonth(Long employeeId, YearMonth month) {
	        LocalDate startDate = month.atDay(1);
	        LocalDate endDate = month.atEndOfMonth();
	        return attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
	    }
	    public List<Attendaces> getAttendanceForDateRange(Long employeeId, LocalDate startDate, LocalDate endDate) {
	        return attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
	    }

}
