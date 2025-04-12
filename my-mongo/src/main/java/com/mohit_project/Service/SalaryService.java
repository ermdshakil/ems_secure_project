package com.mohit_project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Entity.Salary;
import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Repositry.SalaryRepo;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	//create salary
	// Create salary
	// Create salary
    public Salary createSalary(Salary salary) {
        Optional<Employee> employee = this.employeeRepo.findById(salary.getEmployee().getEmployeeId());
        if (!employee.isPresent()) {
            throw new RuntimeException("Employee not found");
        }
        salary.setEmployee(employee.get());
       double month=salary.getCtc();
       double mS=month/12; 
       salary.setMonthlySalary(mS);
       
       double dS=mS/28;
        salary.setDaylySalary(dS);
         
        return salaryRepo.save(salary);
    }
	//getAll Salary
	public List<Salary> getAllSalary(){
		return this.salaryRepo.findAll();
	}
	//get All salary by employeeid
	public List<Salary> getAllSalaryByEmployeeId(Long employeeId){
		return salaryRepo.findByEmployee_employeeId(employeeId);
	}

}
