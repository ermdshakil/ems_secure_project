package com.mohit_project.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addPayments")
public class AddPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addPaymentId;
	private String punchIn;
	
	private String PunchOut;
	private String status;
	
	
	
	@OneToOne
	@JoinColumn(name = "employee_Id")
	private Employee employee;
}
