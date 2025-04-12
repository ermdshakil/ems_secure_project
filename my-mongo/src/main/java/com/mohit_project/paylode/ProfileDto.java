package com.mohit_project.paylode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
	private Long profileId;
	private Integer employeeId;
	private String joinDate;
	private String phoneNo;
	private String address;
	private String notes;

}
