package com.mohit_project.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rAttendanceId;
	private Long employeeId;
	private LocalDateTime punchInTime;
	private LocalDateTime punchOutTime;
	private String selfiePath; // File path where the selfie is stored
	 @Column(name = "latitude", nullable = false)
	    private String latitude;

	    @Column(name = "longitude", nullable = false)
	    private String longitude;
    
    public RAttendance(Long employeeId, LocalDateTime punchInTime, String selfiePath, String latitude, String longitude) {
        this.employeeId = employeeId;
        this.punchInTime = punchInTime;
        this.selfiePath = selfiePath;
        this.latitude = latitude;
        this.longitude = longitude;
    }
	

}
