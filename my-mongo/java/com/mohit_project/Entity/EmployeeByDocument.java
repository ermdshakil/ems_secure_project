package com.mohit_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_By_documents")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeByDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for EmployeeDocument

    private String matricFileName;
    private String interFileName;
    private String graduationFileName;
    private String pgFileName;
    private String aadharFileName;
    private String panFileName;
    private String dlFileName;

    @ManyToOne
    @JsonBackReference
    private Employee employee;

    // Getters and Setters
}
