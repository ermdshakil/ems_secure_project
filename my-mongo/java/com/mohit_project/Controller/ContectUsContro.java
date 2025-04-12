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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.paylode.*;

import com.mohit_project.Service.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/contectUs")
public class ContectUsContro {
	
	@Autowired
	private ContectUsService contectUsService;
	//create 
	@PostMapping("/")
	public ResponseEntity<ContectUsDto> createContectUs(@RequestBody ContectUsDto contectUsDto){
		ContectUsDto createContectUs=this.contectUsService.createContectUs(contectUsDto);
		return new ResponseEntity<ContectUsDto>(createContectUs,HttpStatus.CREATED);
	}
	//update
	@PostMapping("/{contectUsId}")
	public ResponseEntity<ContectUsDto> updateContectUs(@RequestBody ContectUsDto contectUsDto,@PathVariable Long contectUsId){
		ContectUsDto updateContectUs=this.contectUsService.updateContectUs(contectUsDto, contectUsId);
		return ResponseEntity.ok(updateContectUs);
	}
	//delete
	@DeleteMapping("/{contectUsId}")
	public ResponseEntity<ApiResponse> deleteContectUs(@PathVariable Long contectUsId){
		this.contectUsService.deleteContectUs(contectUsId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getContectUsId
	@GetMapping("/{contectUsId}")
	public ResponseEntity<ContectUsDto> getContectUsId(@PathVariable Long contectUsId){

		return ResponseEntity.ok(this.contectUsService.getContectUsId(contectUsId));
	}
	//getAllContectUs
	@GetMapping("/")
	public ResponseEntity<List<ContectUsDto>> getAllContectUs(){
		return ResponseEntity.ok(this.contectUsService.getAllContectUs());
	}
}
