package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.CalculateSalaryDto;







public interface CalculateSalaryService {
	
	CalculateSalaryDto createCalculateSalary(CalculateSalaryDto CalculateSalaryDto);
	CalculateSalaryDto updateCalculateSalary(CalculateSalaryDto calculateSalaryDto,Long CalculateSalaryId);
	void deleteCalculateSalary(Long CalculateSalaryId);
	CalculateSalaryDto getCalculateSalaryId(Long CalculateSalaryId);
	List<CalculateSalaryDto> getAllCalculateSalary();

}
