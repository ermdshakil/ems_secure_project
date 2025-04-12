package com.mohit_project.serviceIpml;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Entity.EmployeeDocument;
import com.mohit_project.Repositry.EmployeeDocumentRepository;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private EmployeeDocumentRepository documentRepository;

    private final String UPLOAD_DIR = "C:\\Users\\Mohit Kumar\\New folder (2)/";

    public void saveDocumentDetails(MultipartFile matric, MultipartFile inter, MultipartFile graduation,
            MultipartFile pg, MultipartFile aadhar, MultipartFile pan, MultipartFile dl,
            String employeeId) throws IOException {
try {
saveFile(matric, employeeId, "matric");
saveFile(inter, employeeId, "inter");
saveFile(graduation, employeeId, "graduation");
saveFile(pg, employeeId, "pg");
saveFile(aadhar, employeeId, "aadhar");
saveFile(pan, employeeId, "pan");
saveFile(dl, employeeId, "dl");

EmployeeDocument document = new EmployeeDocument(employeeId, matric.getOriginalFilename(),
inter.getOriginalFilename(), graduation.getOriginalFilename(),
pg.getOriginalFilename(), aadhar.getOriginalFilename(),
pan.getOriginalFilename(), dl.getOriginalFilename());

documentRepository.save(document);
} catch (IOException e) {
// Log the exception for debugging
System.err.println("File saving failed: " + e.getMessage());
e.printStackTrace();
throw e;  // rethrow the exception to be handled by the controller
} catch (Exception e) {
// Handle other potential exceptions
System.err.println("An error occurred: " + e.getMessage());
e.printStackTrace();
throw new RuntimeException("An unexpected error occurred while saving documents.");
}
}
    private void saveFile(MultipartFile file, String employeeId, String fileType) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty or null");
        }
        // Ensure the upload directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Create the directory if it does not exist
        }
        // Construct the file path
        String filePath = UPLOAD_DIR + employeeId + "_" + fileType + "_" + file.getOriginalFilename();
        File destinationFile = new File(filePath);
        // Save the file
        file.transferTo(destinationFile);
    }
    public Optional<EmployeeDocument> getEmployeeDocumentById(String employeeId) {
        return documentRepository.findById(employeeId);
    }
    public Resource loadDocumentAsResource(String employeeId, String fileName) {
        Optional<EmployeeDocument> documentOptional = documentRepository.findById(employeeId);
        if (documentOptional.isPresent()) {
            EmployeeDocument document = documentOptional.get();
            // Assuming fileName exists and contains the file data
            byte[] fileData = null; // Retrieve the actual file data from your storage (database or filesystem)
            
            return new ByteArrayResource(fileData);
        } else {
            return null;
        }
    }
    

}
