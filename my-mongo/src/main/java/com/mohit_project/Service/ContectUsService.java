package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.ContectUsDto;







public interface ContectUsService {
	ContectUsDto createContectUs(ContectUsDto contectUsDto);
	ContectUsDto updateContectUs(ContectUsDto contectUsDto,Long contectUsId);
	void deleteContectUs(Long contectUsId);
	ContectUsDto getContectUsId(Long contectUsId);
	List<ContectUsDto> getAllContectUs();

}
