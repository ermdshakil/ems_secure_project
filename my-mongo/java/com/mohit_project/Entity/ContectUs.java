package com.mohit_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contects")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContectUs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contectId;
	private String name;
	private String username;
	private String email;
	

}
