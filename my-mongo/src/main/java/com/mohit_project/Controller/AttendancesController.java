package com.mohit_project.Controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Entity.Attendances;
import com.mohit_project.Entity.Employee;
import com.mohit_project.Service.AttendancesService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/attendance")
public class AttendancesController {

    @Autowired
    private AttendancesService attendanceService;
    
//    @PostMapping("/punchIn")
//    public ResponseEntity<Long> punchIn(@RequestBody Employee employee){
//    	Attendances attendances=this.attendanceService.punchIn(employee);
//    	return ResponseEntity.ok(attendances.getId());
//    }
//    
    @PostMapping("/punchIn")
    public ResponseEntity<Long> punchIn(@RequestBody Employee employee) {Long employeeId = employee.getEmployeeId();
    if (employeeId == null) {
        return ResponseEntity.badRequest().body(employeeId);
    }
    
    // Assuming punchIn returns an attendance ID
    Long attendanceId = attendanceService.punchIn(employeeId);
    if (attendanceId == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(employeeId);
    }
    
    return ResponseEntity.ok(attendanceId);
}
//    @PostMapping("/punchOut/{employeeId}")
//    public ResponseEntity<String> punchOut(@PathVariable Long employeeId) {
//    	
//        Attendances attendanceId = attendanceService.punchOut(employeeId);
//        if (attendanceId == null) {
//            return ResponseEntity.badRequest().body("Punch Out failed. Check if you have punched in.");
//        }
//        return ResponseEntity.ok("Punch Out successful. Attendance ID: " + attendanceId);
//    }
    @PostMapping("/punchOut/{attendanceId}")
    public ResponseEntity<String> punchOut(@PathVariable Long attendanceId, @RequestParam(required = false) Integer timer) {
        try {
            Attendances updatedAttendance = attendanceService.punchOut(attendanceId, timer);
            return ResponseEntity.ok("Punch Out successful. Attendance ID: " + updatedAttendance.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/byEmployee/{employeeId}")
    public ResponseEntity<List<Attendances>> getAttendancesByEmployeeId(@PathVariable Long employeeId) {
        List<Attendances> attendances = attendanceService.getAttendancesByEmployeeId(employeeId);
        return ResponseEntity.ok(attendances);
    }

}
