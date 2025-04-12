package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.ReportDto;



public interface ReportService {
	
	ReportDto createReport(ReportDto reportDto);
	ReportDto updateReport(ReportDto reportDto,Long reportId);
	void deleteReport(Long reportId);
	ReportDto getReportId(Long reportId);
	List<ReportDto> getAllReport();

}
