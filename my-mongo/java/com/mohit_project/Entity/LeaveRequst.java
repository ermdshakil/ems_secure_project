package com.mohit_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequst {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lRId;
	private String leaveType;
	private String remark;
	private String leaveFrom;
	private String leaveTo;
	
	 @ManyToOne
	    @JoinColumn(name = "employee_id", nullable = false)
	 @JsonBackReference
	    private Employee employee;
	

}
