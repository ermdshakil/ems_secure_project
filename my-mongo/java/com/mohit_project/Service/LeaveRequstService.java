package com.mohit_project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Entity.LeaveRequst;
import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Repositry.LeaveRequstRepo;



@Service
public class LeaveRequstService {
	
	@Autowired
	private LeaveRequstRepo leaveRequstRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<LeaveRequst> getAllLeaveRequsts() {
        return leaveRequstRepo.findAll();
    }

    public LeaveRequst getLeaveRequstById(Long id) {
        return leaveRequstRepo.findById(id).orElse(null);
    }

    public LeaveRequst createLeaveRequst(LeaveRequst leaveRequst, Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        leaveRequst.setEmployee(employee);
        return leaveRequstRepo.save(leaveRequst);
    }


    public LeaveRequst updateLeaveRequst(Long id, LeaveRequst LeaveRequstDetails) {
        LeaveRequst LeaveRequst = leaveRequstRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("LeaveRequst not found"));

        LeaveRequst.setLeaveType(LeaveRequstDetails.getLeaveType());
        LeaveRequst.setRemark(LeaveRequstDetails.getRemark());
        LeaveRequst.setLeaveFrom(LeaveRequstDetails.getLeaveFrom());
        LeaveRequst.setLeaveTo(LeaveRequstDetails.getLeaveTo());
        // Set other fields as necessary

        return leaveRequstRepo.save(LeaveRequst);
    }

    public void deleteLeaveRequst(Long id) {
        leaveRequstRepo.deleteById(id);
    }
    public List<LeaveRequst> getLeaveRequestsByEmployeeId(Long employeeId) {
        return leaveRequstRepo.findByEmployee_employeeId(employeeId);
    }

}
