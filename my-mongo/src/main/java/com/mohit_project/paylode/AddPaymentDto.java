package com.mohit_project.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentDto {
	
	private long addPaymentId;
    private String punchIn;
	
	private String PunchOut;
	private String status;

}
