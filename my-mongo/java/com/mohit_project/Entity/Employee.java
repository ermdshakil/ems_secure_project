package com.mohit_project.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String name;
	private String zName;
	private String email;
	private String mobile;
	private String dob;
	private String password;
	private String fname;
	private Double salary;
	private String address;
	private String jod;
	private String gender;
	private String category;
	private String marritalStatus;
	private String status;
	private String site;
	private String work;
	private String zmageName;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	 @JsonManagedReference
    private List<Attendance> attendances;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @JsonManagedReference
   private List<Attendances> attendance;
	 @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LeaveRequst> leaveRequests = new ArrayList();
	 @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<EmployeeByDocument> employeeByDocuments = new ArrayList();
//	 @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//	 @JsonManagedReference
//	    private List<Salary> salaries = new ArrayList();
	 @OneToMany(mappedBy = "employee")
	    private Set<Salary> salaries;
	 @Override
	    public String toString() {
	        // Ensure there's no recursive call here
	        return "Employee [id=" + employeeId + ", name=" + name + "]";
	    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public String getUsername() {
		return email;
	}

}
