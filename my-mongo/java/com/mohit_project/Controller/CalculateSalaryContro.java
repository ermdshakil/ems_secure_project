package com.mohit_project.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mohit_project.paylode.*;
import com.mohit_project.Service.*;

//@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/calculateSalary")
public class CalculateSalaryContro {
	
	@Autowired
	private CalculateSalaryService calculateSalaryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CalculateSalaryDto> createCalculateSalary(@RequestBody CalculateSalaryDto calculateSalaryDto){
		CalculateSalaryDto createCalculateSalary=this.calculateSalaryService.createCalculateSalary(calculateSalaryDto);
		return new ResponseEntity<CalculateSalaryDto>(createCalculateSalary,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{calculateSalaryId}")
	public ResponseEntity<CalculateSalaryDto> updateCalculateSalary(@RequestBody CalculateSalaryDto calculateSalaryDto,@PathVariable Long calculateSalaryId){
		CalculateSalaryDto updateCalculateSalary=this.calculateSalaryService.updateCalculateSalary(calculateSalaryDto, calculateSalaryId);
		return ResponseEntity.ok(updateCalculateSalary);
	}
	//delete
	@DeleteMapping("/{calculateSalaryId}")
	public ResponseEntity<ApiResponse> deleteCalculateSalary(@PathVariable Long calculateSalaryId){
		this.calculateSalaryService.deleteCalculateSalary(calculateSalaryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getCalculateSalaryId
	@GetMapping("/{calculateSalaryId}")
	public ResponseEntity<CalculateSalaryDto> getCalculateSalaryId(@PathVariable Long calculateSalaryId){
		return ResponseEntity.ok(this.calculateSalaryService.getCalculateSalaryId(calculateSalaryId));
	}
	//getAllCalculateSalary
	@GetMapping("/")
	public ResponseEntity<List<CalculateSalaryDto>> getAllCalculateSalary(){
		return ResponseEntity.ok(this.calculateSalaryService.getAllCalculateSalary());
	}

}
