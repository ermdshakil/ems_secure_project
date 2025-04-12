package com.mohit_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_documents")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDocument {

   
    @Id
    private String employeeId;
    private String matricFileName;
    private String interFileName;
    private String graduationFileName;
    private String pgFileName;
    private String aadharFileName;
    private String panFileName;
    private String dlFileName;


    // Getters and Setters
}
