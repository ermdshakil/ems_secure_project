package com.mohit_project.Controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Entity.EmployeeDocument;
import com.mohit_project.serviceIpml.DocumentService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;


import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

	 @Autowired
	    private DocumentService documentService;

	    @PostMapping("/")
	    public ResponseEntity<String> uploadDocuments(
	            @RequestParam("matric") MultipartFile matric,
	            @RequestParam("inter") MultipartFile inter,
	            @RequestParam("graduation") MultipartFile graduation,
	            @RequestParam("pg") MultipartFile pg,
	            @RequestParam("aadhar") MultipartFile aadhar,
	            @RequestParam("pan") MultipartFile pan,
	            @RequestParam("dl") MultipartFile dl,
	            @RequestParam("employeeId") String employeeId
	    ) {
	        try {
	            documentService.saveDocumentDetails(matric, inter, graduation, pg, aadhar, pan, dl, employeeId);
	            return new ResponseEntity<>("Files uploaded and details saved successfully!", HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>("File upload failed!", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    // GET endpoint to retrieve EmployeeDocument by employeeId
	    @GetMapping("/{employeeId}")
	    public ResponseEntity<EmployeeDocument> getEmployeeDocument(@PathVariable String employeeId) {
	        Optional<EmployeeDocument> documentOptional = documentService.getEmployeeDocumentById(employeeId);

	        if (documentOptional.isPresent()) {
	            return new ResponseEntity<>(documentOptional.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @GetMapping("/image/{employeeId}/{fileName}")
	    public ResponseEntity<Resource> getDocumentImage(@PathVariable String employeeId, @PathVariable String fileName) {
	        Resource resource = documentService.loadDocumentAsResource(employeeId, fileName);

	        if (resource != null) {
	            return ResponseEntity.ok()
	                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"")
	                    .body(resource);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    

}
