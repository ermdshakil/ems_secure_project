package com.mohit_project.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Entity.RAttendance;
import com.mohit_project.Service.RAttendanceService;

@RestController
@RequestMapping("/api/rAttendance")
public class RAttendanceController {
	@Autowired
    private RAttendanceService rAttendanceService;

    @PostMapping("/punchIn")
    public ResponseEntity<String> punchIn(
            @RequestParam("employeeId") Long employeeId,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            @RequestParam("selfie") MultipartFile selfie) {
        
        // Define the directory where the selfies will be stored
        String directoryPath = "C:/Users/Mohit Kumar/myweb/selfies/";

        // Ensure that the directory exists, and create it if it doesn't
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory (including parent directories if necessary)
        }

        // Save the selfie image to the directory
        String filePath = directoryPath + "selfie_" + employeeId + ".jpg";
        File selfieFile = new File(filePath);
        try {
            selfie.transferTo(selfieFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save selfie", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // If everything is successful, return a success message
        rAttendanceService.punchIn(employeeId, filePath, latitude, longitude);
         
        return new ResponseEntity<>("Punch-in successful with selfie saved!", HttpStatus.OK);
    }

    @PutMapping("/punchOut/{attendanceId}")
    public ResponseEntity<RAttendance> punchOut(@PathVariable Long attendanceId) {
    	RAttendance attendance = rAttendanceService.punchOut(attendanceId);
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }

    private String saveSelfie(MultipartFile file) {
        String directory = "C:/Users/Mohit Kumar/myweb/selfies/";  // Update as per your directory
        String filePath = directory + file.getOriginalFilename();
        File dest = new File(filePath);
        try {
            file.transferTo(dest);  // Save the selfie to the server
        } catch (IOException e) {
            throw new RuntimeException("Failed to save selfie", e);
        }
        return filePath;
    }
    
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<RAttendance>> getAllRAttendanceEmployee(@PathVariable Long employeeId){
    	return ResponseEntity.ok(this.rAttendanceService.getAllRAttendanceByEmployeeId(employeeId));
    }

}
