package com.mohit_project.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Entity.LeaveRequst;
import com.mohit_project.Service.LeaveRequstService;



@RequestMapping("/api")
@RestController
public class LeaveRequstControll {
	
	@Autowired
	private LeaveRequstService leaveRequstService;
	 @GetMapping
	    public List<LeaveRequst> getAllLeaveRequests() {
	        return leaveRequstService.getAllLeaveRequsts();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<LeaveRequst> getLeaveRequestById(@PathVariable Long id) {
	        LeaveRequst leaveRequest = leaveRequstService.getLeaveRequstById(id);
	        return leaveRequest != null ? ResponseEntity.ok(leaveRequest) : ResponseEntity.notFound().build();
	    }

	    @PostMapping("/leave/{employeeId}")
	    public LeaveRequst createLeaveRequest(@PathVariable Long employeeId, @RequestBody LeaveRequst leaveRequest) {
	        return leaveRequstService.createLeaveRequst(leaveRequest, employeeId);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<LeaveRequst> updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequst leaveRequestDetails) {
	        LeaveRequst updatedLeaveRequest = leaveRequstService.updateLeaveRequst(id, leaveRequestDetails);
	        return ResponseEntity.ok(updatedLeaveRequest);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Long id) {
	        leaveRequstService.deleteLeaveRequst(id);
	        return ResponseEntity.noContent().build();
	    }
	    @GetMapping("/leave/{employeeId}")
	    public ResponseEntity<List<LeaveRequst>> getLeaveRequestsByEmployeeId(@PathVariable Long employeeId) {
	        List<LeaveRequst> leaveRequests = leaveRequstService.getLeaveRequestsByEmployeeId(employeeId);
	        return leaveRequests != null && !leaveRequests.isEmpty() ? ResponseEntity.ok(leaveRequests) : ResponseEntity.notFound().build();
	    }
}
