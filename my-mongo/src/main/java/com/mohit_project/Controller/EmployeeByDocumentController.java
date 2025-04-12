//package com.mohit_project.Controller ;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.mohit_project.serviceIpml.EmployeeByDocumentService;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/documents")
//public class EmployeeByDocumentController {
//
//    @Autowired
//    private EmployeeByDocumentService documentService;
//    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";  // Adjust path for server
//
//    // Endpoint to upload documents for an employee
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadDocuments(@RequestParam("matric") MultipartFile matric,
//                                                  @RequestParam("inter") MultipartFile inter,
//                                                  @RequestParam("graduation") MultipartFile graduation,
//                                                  @RequestParam("pg") MultipartFile pg,
//                                                  @RequestParam("aadhar") MultipartFile aadhar,
//                                                  @RequestParam("pan") MultipartFile pan,
//                                                  @RequestParam("dl") MultipartFile dl,
//                                                  @RequestParam("employeeId") Long employeeId) {
//        try {
//            documentService.saveDocumentDetails(matric, inter, graduation, pg, aadhar, pan, dl, employeeId);
//            return ResponseEntity.ok("Documents uploaded successfully.");
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Failed to upload documents: " + e.getMessage());
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(400).body(e.getMessage());
//        }
//    }
//
//    // Endpoint to download a specific document by employee ID and file name
//    @GetMapping("/download/{employeeId}/{fileName}")
//    public ResponseEntity<Resource> downloadDocument(@PathVariable Long employeeId, @PathVariable String fileName) {
//        Resource resource = documentService.loadDocumentAsResource(employeeId, fileName);
//        if (resource != null) {
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
//                    .body(resource);
//        } else {
//            return ResponseEntity.status(404).body(null);
//        }
//    }
////
////    // Endpoint to get document details by employee ID
////    @GetMapping("/{employeeId}")
////    public ResponseEntity<?> getDocumentDetails(@PathVariable Long employeeId) {
////        return documentService.getEmployeeDocumentById(employeeId)
////                .map(document -> ResponseEntity.ok(document))
////                .orElseGet(() -> ResponseEntity.status(404).body("Document not found for employee ID: " + employeeId));
////    }
//
//}
package com.mohit_project.Controller ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.serviceIpml.EmployeeByDocumentService;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
//@CrossOrigin(origins = "*") // Allow all origins for development, update in production
public class EmployeeByDocumentController {
//
//    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";  // Adjust path for server
//
//    @PostMapping("/upload")
//    public ResponseEntity<?> uploadDocuments(
//            @RequestParam("employeeId") String employeeId,
//            @RequestParam("matric") MultipartFile matric,
//            @RequestParam("inter") MultipartFile inter,
//            @RequestParam("graduation") MultipartFile graduation,
//            @RequestParam("pg") MultipartFile pg,
//            @RequestParam("aadhar") MultipartFile aadhar,
//            @RequestParam("pan") MultipartFile pan,
//            @RequestParam("dl") MultipartFile dl) {
//
//        try {
//            // Create the upload directory if it doesn't exist
//            File uploadDir = new File(UPLOAD_DIR);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//
//            // Save files
//            saveFile(matric, "matric_" + employeeId);
//            saveFile(inter, "inter_" + employeeId);
//            saveFile(graduation, "graduation_" + employeeId);
//            saveFile(pg, "pg_" + employeeId);
//            saveFile(aadhar, "aadhar_" + employeeId);
//            saveFile(pan, "pan_" + employeeId);
//            saveFile(dl, "dl_" + employeeId);
//
//            return ResponseEntity.ok("Documents uploaded successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to upload documents: " + e.getMessage());
//        }
//    }
//
//    private void saveFile(MultipartFile file, String filename) throws IOException {
//        if (!file.isEmpty()) {
//            File dest = new File(UPLOAD_DIR + "/" + filename + "_" + file.getOriginalFilename());
//            file.transferTo(dest);
//        }
//    }
//}
//
//private final EmployeeByDocumentService documentService;
//
//public DocumentController(DocumentService documentService) {
//    this.documentService = documentService;
//}
	 @Autowired
   private EmployeeByDocumentService documentService;
	

@PostMapping("/upload")
public ResponseEntity<?> uploadDocuments(
        @RequestParam("employeeId") String employeeId,
        @RequestParam("matric") MultipartFile matric,
        @RequestParam("inter") MultipartFile inter,
        @RequestParam("graduation") MultipartFile graduation,
        @RequestParam("pg") MultipartFile pg,
        @RequestParam("aadhar") MultipartFile aadhar,
        @RequestParam("pan") MultipartFile pan,
        @RequestParam("dl") MultipartFile dl) {

    try {
        // Use service to handle file saving logic
        documentService.uploadDocument(matric, "matric_" + employeeId);
        documentService.uploadDocument(inter, "inter_" + employeeId);
        documentService.uploadDocument(graduation, "graduation_" + employeeId);
        documentService.uploadDocument(pg, "pg_" + employeeId);
        documentService.uploadDocument(aadhar, "aadhar_" + employeeId);
        documentService.uploadDocument(pan, "pan_" + employeeId);
        documentService.uploadDocument(dl, "dl_" + employeeId);

        return ResponseEntity.ok("Documents uploaded successfully");
    } catch (IOException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to upload documents: " + e.getMessage());
    }
}
}