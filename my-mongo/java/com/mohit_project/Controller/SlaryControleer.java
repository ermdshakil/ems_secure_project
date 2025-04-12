package com.mohit_project.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mohit_project.Entity.Salary;
import com.mohit_project.Service.SalaryService;

@RestController
@RequestMapping("/api/salary")
public class SlaryControleer {
	
	@Autowired
	private SalaryService salaryService;
	
	//create salry
	
	  // Endpoint to create a salary
	@PostMapping("/create")
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
        try {
            Salary createdSalary = salaryService.createSalary(salary);
            return new ResponseEntity<>(createdSalary, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
	//getAll salary
	@GetMapping("/")
	public ResponseEntity<List<Salary>> getAllSalary(){
		return ResponseEntity.ok(this.salaryService.getAllSalary());
	}
	
	//getAll salary by employeeId
	@GetMapping("/byEmployee/{employeeId}")
	public ResponseEntity<List<Salary>> getAllSalaryByEmployeeId(@PathVariable Long employeeId){
		List<Salary> attendances = salaryService.getAllSalaryByEmployeeId(employeeId);
        return ResponseEntity.ok(attendances);
		
	}

}
