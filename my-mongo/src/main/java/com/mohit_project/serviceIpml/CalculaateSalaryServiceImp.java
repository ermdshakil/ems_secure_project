package com.mohit_project.serviceIpml;

import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.CalculateSalary;
import com.mohit_project.Repositry.CalculateSalaryRepo;
import com.mohit_project.Service.CalculateSalaryService;
import com.mohit_project.exception.ResourceNotFoundException;
import com.mohit_project.paylode.CalculateSalaryDto;


@Service
public class CalculaateSalaryServiceImp implements CalculateSalaryService {
	
	@Autowired
	private CalculateSalaryRepo calculateSalaryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CalculateSalaryDto createCalculateSalary(CalculateSalaryDto CalculateSalaryDto) {
		// TODO Auto-generated method stub
		CalculateSalary calculateSalary=this.modelMapper.map(CalculateSalaryDto, CalculateSalary.class);
		CalculateSalary createCalculateSalary=this.calculateSalaryRepo.save(calculateSalary);
		return this.modelMapper.map(createCalculateSalary, CalculateSalaryDto.class);
	}

	@Override
	public CalculateSalaryDto updateCalculateSalary(CalculateSalaryDto calculateSalaryDto, Long CalculateSalaryId) {
		// TODO Auto-generated method stub
		CalculateSalary calculateSalary=this.calculateSalaryRepo.findById(CalculateSalaryId).orElseThrow(()-> new ResourceNotFoundException("CalculateSalary", "Id", CalculateSalaryId));
		
		calculateSalary.setCategory(calculateSalaryDto.getCategory());
		CalculateSalary updateCalculateSalary=this.calculateSalaryRepo.save(calculateSalary);
		
		return this.modelMapper.map(updateCalculateSalary, CalculateSalaryDto.class);
	}

	@Override
	public void deleteCalculateSalary(Long CalculateSalaryId) {
		// TODO Auto-generated method stub
		CalculateSalary calculateSalary=this.calculateSalaryRepo.findById(CalculateSalaryId).orElseThrow(()-> new ResourceNotFoundException("CalculateSalary", "Id", CalculateSalaryId));

		this.calculateSalaryRepo.delete(calculateSalary);
		
	}

	@Override
	public CalculateSalaryDto getCalculateSalaryId(Long CalculateSalaryId) {
		// TODO Auto-generated method stub
		CalculateSalary calculateSalary=this.calculateSalaryRepo.findById(CalculateSalaryId).orElseThrow(()-> new ResourceNotFoundException("CalculateSalary", "Id", CalculateSalaryId));

		return this.modelMapper.map(calculateSalary, CalculateSalaryDto.class);
	}

	@Override
	public List<CalculateSalaryDto> getAllCalculateSalary() {
		// TODO Auto-generated method stub
		List<CalculateSalary> calculateSalaries=this.calculateSalaryRepo.findAll();
		List<CalculateSalaryDto> calculateSalaryDtos=calculateSalaries.stream().map((cs)->this.modelMapper.map(cs, CalculateSalaryDto.class)).collect(Collectors.toList());
		
		return calculateSalaryDtos;
	}

}
