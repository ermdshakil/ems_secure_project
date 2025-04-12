package com.mohit_project.Repositry;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.EmployeeDocument;




public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocument, String> {
}
