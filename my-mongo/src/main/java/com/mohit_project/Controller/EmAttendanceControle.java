package com.mohit_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohit_project.Entity.EmAttendance;
import com.mohit_project.Entity.Employee;
import com.mohit_project.Service.EmAttendanceService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attendances")
public class EmAttendanceControle {

    @Autowired
    private EmAttendanceService attendanceService;

//    @PostMapping("/punchIn")
//    public ResponseEntity<Long> punchIn(@RequestBody Employee employeel) {
//        EmAttendance attendance = attendanceService.punchIn(employeel);
//        return ResponseEntity.ok(attendance.getId());
//    }
//    @PostMapping("/punchIn")
//    public ResponseEntity<?> punchIn(@RequestBody EmAttendance emAttendance) {
//        attendanceService.punchIn(emAttendance);
//        return ResponseEntity.ok().build();
//    }
    @PostMapping("/punchIn")
    public ResponseEntity<Long> punchIn(@RequestBody EmAttendance emAttendance) {
        // Save the attendance record and get the saved entity
        EmAttendance savedAttendance = attendanceService.punchIn(emAttendance);
        
        // Extract the attendance ID
        Long attendanceid = savedAttendance.getId(); // Assuming `getAttendanceId()` retrieves the ID
        
        // Return the ID in the response
        return ResponseEntity.ok(attendanceid);
    }

    @PostMapping("/punchOut/{id}")
    public ResponseEntity<String> punchOut(@PathVariable Long id) {
        EmAttendance attendance = attendanceService.punchOut(id);
        if (attendance != null) {
            return ResponseEntity.ok("Punched out successfully with ID: " + attendance.getId());
        } else {
            return ResponseEntity.badRequest().body("Attendance record not found");
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmAttendance>> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
        List<EmAttendance> attendanceList = attendanceService.getAttendanceByEmployeeId(employeeId);
        return ResponseEntity.ok(attendanceList);
    }
//    @PostMapping("/punchOut/{attendanceId}")
//    public ResponseEntity<String> punchOut(@PathVariable Long attendanceId, @RequestBody Map<String, Object> requestData) {
//        int timer = (int) requestData.get("timer");
//        boolean success = attendanceService.punchOut(attendanceId, timer);
//        if (success) {
//            return ResponseEntity.ok("Punched out successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Punch out failed.");
//        }
//    }
}
