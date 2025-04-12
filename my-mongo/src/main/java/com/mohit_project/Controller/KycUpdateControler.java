package com.mohit_project.Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Entity.KycUpdate;
import com.mohit_project.Entity.RAttendance;
import com.mohit_project.Service.KycUpdateService;
import com.mohit_project.paylode.EmployeeDto;

@RestController
@RequestMapping("/api")
public class KycUpdateControler {
	
	private final Path rootLocation = Paths.get("C:/Users/Mohit Kumar/myweb/uploads");
	
	@Autowired
	private KycUpdateService kycUpdateService;
	
//	 @PostMapping("/create")
//	    public ResponseEntity<String> createEmployee(
//	            @RequestParam("employeeId") Long employeeId,
//	            @RequestParam("aadharNo") String aadharNo,
//	            @RequestParam("aadharDoc") MultipartFile aadharDoc,
//	            @RequestParam("panNo") String panNo,
//	            @RequestParam("panDoc") MultipartFile panDoc,
//	            @RequestParam("accountNo") String accountNo,
//	            @RequestParam("ifsc") String ifsc,
//	            @RequestParam("bankName") String bankName,
//	            @RequestParam("bankAddress") String bankAddress,
//	            @RequestParam("passbookDoc") MultipartFile passbookDoc,
//	            @RequestParam("kycStatus") String kycStatus) {
//	        
//	        try {
//	            kycUpdateService.createEmployee(employeeId, aadharNo, aadharDoc, panNo, panDoc, accountNo, ifsc, bankName, bankAddress, passbookDoc, kycStatus);
//	            return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
//	        } catch (IOException e) {
//	            return new ResponseEntity<>("Failed to create employee", HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//	    }
	 @PostMapping("/create")
	    public ResponseEntity<String> createEmployee(
	            @RequestParam("employeeId") Long employeeId,
	            @RequestParam("aadharNo") String aadharNo,
	            @RequestParam("aadharDoc") MultipartFile aadharDoc,
	            @RequestParam("panNo") String panNo,
	            @RequestParam("panDoc") MultipartFile panDoc,
	            @RequestParam("accountNo") String accountNo,
	            @RequestParam("ifsc") String ifsc,
	            @RequestParam("bankName") String bankName,
	            @RequestParam("bankAddress") String bankAddress,
	            @RequestParam("passbookDoc") MultipartFile passbookDoc,
	            @RequestParam("kycStatus") String kycStatus) {
	        
	        try {
	            kycUpdateService.createEmployee(employeeId, aadharNo, aadharDoc, panNo, panDoc, accountNo, ifsc, bankName, bankAddress, passbookDoc, kycStatus);
	            return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
	        } catch (IOException e) {
	            return new ResponseEntity<>("Failed to create employee", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	 @GetMapping("/kyc/{employeeId}")
		public ResponseEntity<List<KycUpdate>> getEmployeeBId(@PathVariable Long employeeId){
			return ResponseEntity.ok(this.kycUpdateService.getByEmployeeId(employeeId));
		}

}
