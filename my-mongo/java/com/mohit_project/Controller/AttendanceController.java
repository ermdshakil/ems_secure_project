//package com.mohit_project.Controller;
//
//
//import com.mohit_project.Entity.Attendance;
//import com.mohit_project.Entity.Employee;
//import com.mohit_project.Service.AttendanceService;
//import com.mohit_project.paylode.EmployeeDto;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/attendance")
//public class AttendanceController {
//
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @CrossOrigin(origins = "http://localhost:5173")  // Replace with your client URL
//    @PostMapping("/punchIn")
//    public ResponseEntity<Long> punchIn(@RequestBody Employee employeel) {
//        Attendance attendance = attendanceService.punchIn(employeel);
//        return ResponseEntity.ok(attendance.getId());
//    }
//
//    @PostMapping("/punchOut/{attendanceId}")
//    public ResponseEntity<Attendance> punchOut(
//            @PathVariable Long attendanceId,
//            @RequestBody(required = false) Integer timer) {
//        Attendance attendance = attendanceService.punchOut(attendanceId, timer);
//        return ResponseEntity.ok(attendance);
//    }
////
////    @GetMapping("/employee/{employeeId}")
////    public ResponseEntity<List<Attendance>> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
////        Employee employee = attendanceService.findEmployeeById(employeeId);
////        List<Attendance> attendances = attendanceService.getAttendanceByEmployee(employee);
////        return ResponseEntity.ok(attendances);
////    }
//    @GetMapping("/employee/{employeeId}")
//    public List<Attendance> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
//        return attendanceService.getAttendanceByEmployeeId(employeeId);
//    }
//    @GetMapping("/format")
//    public String formatDateTime(@RequestParam String dateTime) {
//        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
//        return attendanceService.formatDateTime(localDateTime);
//    }
//
//    @GetMapping("/attendance/{id}")
//    public Attendance getAttendance(@PathVariable Long id) {
//        return attendanceService.getAttendanceById(id);
//    }
//
//    @GetMapping("/attendance/{id}/formatted")
//    public String getFormattedAttendance(@PathVariable Long id) {
//        Attendance attendance = attendanceService.getAttendanceById(id);
//        if (attendance != null) {
//            String punchInFormatted = attendanceService.formatDateTime(attendance.getPunchIn());
//            String punchOutFormatted = attendanceService.formatDateTime(attendance.getPunchOut());
//            return String.format("Punch In: %s, Punch Out: %s", punchInFormatted, punchOutFormatted);
//        }
//        return "Attendance record not found";
//    }
////    @GetMapping("/a/{employeeId}")
////    public List<String> getFormattedAttendanceByEmployeeId(@PathVariable Long employeeId) {
////        return attendanceService.getFormattedAttendanceByEmployeeId(employeeId);
////    }
//    @GetMapping("/a/{employeeId}")
//    public List<String> getFormattedAttendanceByEmployeeId(@PathVariable Long employeeId) {
//        return attendanceService.getFormattedAttendanceByEmployeeId(employeeId);
//    }
//}
