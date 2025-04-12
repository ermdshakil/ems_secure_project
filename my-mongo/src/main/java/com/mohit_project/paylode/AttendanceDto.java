package com.mohit_project.paylode;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mohit_project.config.CustomLocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
	private Long attendanceId;
	 private Long employeeId;
	    private String employeeName;

	    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	    private LocalDateTime punchIn;
	    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	    private LocalDateTime punchOut;
	    private String status;


}
