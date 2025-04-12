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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.paylode.*;
import com.mohit_project.paylode.*;
import com.mohit_project.Service.*;

//@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
//@CrossOrigin("*")
@RestController
@RequestMapping("/api/addPayment")
public class AddPaymentContro {
	
	@Autowired
	private AddPaymentService addPaymentService;
	//create
	@PostMapping("/")
	public ResponseEntity<AddPaymentDto> createAddPayment(@RequestBody AddPaymentDto addPaymentDto){
		AddPaymentDto createAddPayment=this.addPaymentService.createAddPayment(addPaymentDto);
		return new ResponseEntity<AddPaymentDto>(createAddPayment,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{addPaymentId}")
	public ResponseEntity<AddPaymentDto> updateAddPayment(@RequestBody AddPaymentDto addPaymentDto,@PathVariable Long addPaymentId){
		AddPaymentDto updateAddPayment=this.addPaymentService.updateAddPayment(addPaymentDto, addPaymentId);
		return ResponseEntity.ok(updateAddPayment);
	}
	//delete
	@DeleteMapping("/{addPaymentId}")
	public ResponseEntity<ApiResponse> deleteAddPayment(@PathVariable Long addPaymentId){
		this.addPaymentService.deleteAddPayment(addPaymentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getAddPaymentId
	@GetMapping("/{addPaymentId}")
	public ResponseEntity<AddPaymentDto> getAddPaymentId(@PathVariable Long addPaymentId){
		return ResponseEntity.ok(this.addPaymentService.getAddPaymentId(addPaymentId));
	}
	//getAllAddPayment
	@GetMapping("/")
	public ResponseEntity<List<AddPaymentDto>> getAllAddPayment(){
		return ResponseEntity.ok(this.addPaymentService.getAllAddPayment());
	}
	

}
