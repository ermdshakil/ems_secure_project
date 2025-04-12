//package com.mohit_project.serviceIpml;
//
//
//
//import com.mohit_project.Entity.*;
//import com.mohit_project.Entity.Attendance;
//import com.mohit_project.Entity.Employee;
//import com.mohit_project.Repositry.AttendanceRepository;
//import com.mohit_project.Repositry.EmployeeRepo;
//import com.mohit_project.Service.AttendanceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class AttendanceServiceImpl implements AttendanceService {
//
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//
//    @Autowired
//    private EmployeeRepo employeeRepository;
//    
//    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
//
//   
//    @Override
//    public Attendance punchOut(Long attendanceId, Integer timer) {
//        Attendance attendance = attendanceRepository.findById(attendanceId)
//                .orElseThrow(() -> new RuntimeException("Attendance not found"));
//
//        LocalDateTime punchOutTime = LocalDateTime.now();
//        attendance.setPunchOut(punchOutTime);
//
//        // If timer is provided, use it; otherwise, calculate it
//        if (timer != null) {
//            attendance.setTimer(timer);
//        } else {
//            long secondsElapsed = Duration.between(attendance.getPunchIn(), attendance.getPunchOut()).getSeconds();
//            attendance.setTimer((int) secondsElapsed);
//        }
//
//        return attendanceRepository.save(attendance);
//    }
//
//    @Override
//    public List<Attendance> getAttendanceByEmployee(Employee employee) {
//        return attendanceRepository.findByEmployee(employee);
//    }
//
//    @Override
//    public Employee findEmployeeById(Long employeeId) {
//        return employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//    }
//
//	
//	@Override
//	public Attendance punchIn(Employee employee)  {
//        Attendance attendance = new Attendance();
//        attendance.setEmployee(employee);
//        attendance.setPunchIn(LocalDateTime.now());
//        return attendanceRepository.save(attendance);
//    }
//	@Override
//	public List<Attendance> getAttendanceByEmployeeId(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//        return attendanceRepository.findByEmployee(employee);
//    }
//
//	@Override
//	public String formatDateTime(LocalDateTime dateTime) {
//        return dateTime.format(FORMATTER);
//    }
//	 public Attendance getAttendanceById(Long id) {
//	        return attendanceRepository.findById(id).orElse(null);
//	    }
//
//	@Override
////	 public List<String> getFormattedAttendanceByEmployeeId(Long employeeId) {
////        List<Attendance> attendances = getAttendanceByEmployeeId(employeeId);
////        return attendances.stream().map(attendance -> {
////            String punchIn = attendance.getPunchIn() != null ? formatDateTime(attendance.getPunchIn()) : "N/A";
////            String punchOut = attendance.getPunchOut() != null ? formatDateTime(attendance.getPunchOut()) : "N/A";
////            Integer i=attendance.getTimer();
////            return String.format("Punch In: %s, Punch Out: %s", punchIn, punchOut);
////        }).collect(Collectors.toList());
////    }
//	public List<String> getFormattedAttendanceByEmployeeId(Long employeeId) {
//        List<Attendance> attendances = getAttendanceByEmployeeId(employeeId);
//        return attendances.stream().map(attendance -> {
//            String punchIn = attendance.getPunchIn() != null ? formatDateTime(attendance.getPunchIn()) : "N/A";
//            String punchOut = attendance.getPunchOut() != null ? formatDateTime(attendance.getPunchOut()) : "N/A";
//            String duration = attendance.getPunchIn() != null && attendance.getPunchOut() != null
//                ? formatDuration(attendance.getDuration()) : "N/A";
//            return String.format("Punch In: %s, Punch Out: %s, Duration: %s", punchIn, punchOut, duration);
//        }).collect(Collectors.toList());
//    }
//
//    private String formatDuration(Duration duration) {
//        long hours = duration.toHours();
//        long minutes = duration.toMinutes() % 60;
//        long seconds = duration.getSeconds() % 60;
//        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
//    }
//}
