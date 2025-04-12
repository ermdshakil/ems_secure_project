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

import com.mohit_project.Service.ReportService;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.paylode.ReportDto;



//@CrossOrigin("*")
@RestController
@RequestMapping("/api/report")
public class ReportContro {
	
	@Autowired
	private ReportService reportService;
	

	//create 
	@PostMapping("/")
	public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto reportDto){
		ReportDto createReport=this.reportService.createReport(reportDto);
		return new ResponseEntity<ReportDto>(createReport,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{reportId}")
	public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto,@PathVariable Long reportId){
		ReportDto updateReport=this.reportService.updateReport(reportDto, reportId);
		return ResponseEntity.ok(updateReport);
	}
	//delete
	@DeleteMapping("/{reportId}")
	public ResponseEntity<ApiResponse> deleteReport(@PathVariable Long reportId){
		this.reportService.deleteReport(reportId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getReportId
	@GetMapping("/{reportId}")
	public ResponseEntity<ReportDto> getReportId(@PathVariable Long reportId){
		return ResponseEntity.ok(this.reportService.getReportId(reportId));
	}
	//getAllReport
	@GetMapping("/")
	public ResponseEntity<List<ReportDto>> getAllReport(){
		return ResponseEntity.ok(this.reportService.getAllReport());
	}
}
