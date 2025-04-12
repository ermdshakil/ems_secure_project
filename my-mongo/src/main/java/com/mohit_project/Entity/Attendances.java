package com.mohit_project.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "atten")
public class Attendances {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JsonBackReference
	    @JoinColumn(name = "employee_id", nullable = false)
	    private Employee employee;

	    private LocalDateTime punchInTime;
	    private LocalDateTime punchOutTime;
	    private int timer;
	    @Override
	    public String toString() {
	        // Ensure there's no recursive call here
	        return "Attendances [id=" + id + ", employee=" + employee + "]";
	    }

}
