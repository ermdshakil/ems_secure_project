package com.mohit_project.Controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Entity.Attendaces;
import com.mohit_project.Service.AttendcesService;

@RestController
@RequestMapping("/api/attendaces")
public class AttendacesController {
	 @Autowired
	    private AttendcesService attendanceService;

	    @GetMapping("/monthly/{employeeId}")
	    public ResponseEntity<List<Attendaces>> getMonthlyAttendance(@PathVariable Long employeeId,
	                                                                 @RequestParam YearMonth month) {
	        List<Attendaces> attendance = attendanceService.getAttendanceForMonth(employeeId, month);
	        return new ResponseEntity<>(attendance, HttpStatus.OK);
	    }
	    @GetMapping("/range/{employeeId}")
	    public ResponseEntity<List<Attendaces>> getAttendanceByDateRange(
	            @PathVariable Long employeeId,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
	        List<Attendaces> attendance = attendanceService.getAttendanceForDateRange(employeeId, startDate, endDate);
	        return new ResponseEntity<>(attendance, HttpStatus.OK);
	    }

}
