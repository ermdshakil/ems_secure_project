package com.mohit_project.serviceIpml;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Service.EmployeeService;
import com.mohit_project.exception.ResourceNotFoundException;
import com.mohit_project.paylode.EmployeeDto;




@Service
public class EmployeeServiceImp implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=this.modelMapper.map(employeeDto, Employee.class);
		Employee createEmployee=this.employeeRepo.save(employee);
		return this.modelMapper.map(createEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		
//		employee.setName(employeeDto.getName());
//		employee.setEmail(employeeDto.getEmail());
//		//employee.setPassword(employeeDto.getPassword());
////		employee.setImageName(employeeDto.getImageName());
////		employee.setZmageName(employeeDto.getZmageName());
//		employee.setSalary(employeeDto.getSalary());
//		employee.setAddress(employeeDto.getAddress());
//		employee.setCategory(employeeDto.getCategory());
//		employee.set
		employee.setAddress(employeeDto.getAddress());
		employee.setCategory(employeeDto.getCategory());
		employee.setDob(employeeDto.getDob());
		employee.setEmail(employeeDto.getEmail());
		employee.setFname(employeeDto.getFname());
		employee.setGender(employeeDto.getGender());
		employee.setJod(employeeDto.getJod());
		employee.setMarritalStatus(employeeDto.getMarritalStatus());
		employee.setMobile(employeeDto.getMobile());
		employee.setName(employeeDto.getName());
		employee.setPassword(employeeDto.getPassword());
		employee.setSalary(employeeDto.getSalary());
		employee.setSite(employeeDto.getSite());
		employee.setStatus(employeeDto.getStatus());
		employee.setWork(employeeDto.getWork());
		
		
		Employee updateEmployee=this.employeeRepo.save(employee);
		return this.modelMapper.map(updateEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
 
		this.employeeRepo.delete(employee);
		
	}

	@Override
	public EmployeeDto getEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));

		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllemployee() {
		// TODO Auto-generated method stub
		List<Employee> employees=this.employeeRepo.findAll();
		List<EmployeeDto> getAllEmployee=employees.stream().map((em)-> this.modelMapper.map(em, EmployeeDto.class)).collect(Collectors.toList());
		return getAllEmployee;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
	
		return employeeRepo.count();
	}

	@Override
	public Double total() {
		// TODO Auto-generated method stub
		List<Employee> employees=this.employeeRepo.findAll();
        return employees.stream().mapToDouble(Employee::getSalary).sum();

		
	}

	@Override
	public long getMaleEmployeeCount() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countMaleEmployees();
	}

	@Override
	public long geFetmaleEmployeeCount() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countFemaleEmployees();
	}

	@Override
	public long getTransEmployeeCount() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countTransEmployees();
	}

	@Override
	public long getCurrentEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countCurrentEmployees();
	}

	@Override
	public long getExEmployeeEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countExEmployeeEmployees();
	}

	@Override
	public long getNewjoiningEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countNewjoiningEmployees();
	}

	@Override
	public long getTransferredInEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countTransferredInEmployees();
	}

	@Override
	public long getTransferredOutEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countTransferredOutEmployees();
	}

	@Override
	public long getExitedEmployeeEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepo.countExitedEmployeeEmployees();
	}
	 public Long validateEmployee(String email, String password) {
	        Optional<Employee> employee = employeeRepo.findByEmailAndPassword(email, password);
	        return employee.map(Employee::getEmployeeId).orElse(null);
	    }
//	 @Override
//	    public List<Employee> validateEmployees(String username, String password) {
//	        // Fetch all employees matching the provided username and password
//	        List<Employee> employees = employeeRepo.findByUsernameAndPassword(username, password);
//
//	        // Optionally filter out any other criteria if needed and return the list
//	        return employees.stream()
//	                        .filter(employee -> employee.getEmail().equals(username) && employee.getPassword().equals(password))
//	                        .collect(Collectors.toList());
//	    }

}
