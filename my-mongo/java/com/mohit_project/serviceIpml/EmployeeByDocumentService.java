package com.mohit_project.serviceIpml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Repositry.EmployeeByDocumentRepo;
import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Entity.*;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class EmployeeByDocumentService {

    @Autowired
    private EmployeeByDocumentRepo documentRepository;

    @Autowired
//    private EmployeeRepo employeeRepo;
//
////    private final String UPLOAD_DIR = "C:\\Users\\Mohit Kumar\\New folder (2)/";
//
//    public void saveDocumentDetails(MultipartFile matric, MultipartFile inter, MultipartFile graduation,
//                                    MultipartFile pg, MultipartFile aadhar, MultipartFile pan, MultipartFile dl,
//                                    Long employeeId) throws IOException {
//        // Retrieve the employee from the database using employeeId
//        Employee employee = employeeRepo.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        try {
//            // Save each file to the specified directory
//            saveFile(matric, employeeId, "matric");
//            saveFile(inter, employeeId, "inter");
//            saveFile(graduation, employeeId, "graduation");
//            saveFile(pg, employeeId, "pg");
//            saveFile(aadhar, employeeId, "aadhar");
//            saveFile(pan, employeeId, "pan");
//            saveFile(dl, employeeId, "dl");
//            
//            EmployeeByDocument document=new EmployeeByDocument();
//            document.setMatricFileName(matric.getOriginalFilename());
//            document.setInterFileName(inter.getOriginalFilename());
//            document.setGraduationFileName(graduation.getOriginalFilename());
//            document.setPgFileName(pg.getOriginalFilename());
//            document.setAadharFileName(aadhar.getOriginalFilename());
//            document.setPanFileName(pan.getOriginalFilename());
//            document.setDlFileName(dl.getOriginalFilename());
//            document.setEmployee(employee);
//
//            // Save the EmployeeDocument entity to the database
//            documentRepository.save(document);
//
//            
//        } catch (IOException e) {
//            System.err.println("File saving failed: " + e.getMessage());
//            e.printStackTrace();
//            throw e;  // rethrow the exception to be handled by the controller
//        } catch (Exception e) {
//            System.err.println("An error occurred: " + e.getMessage());
//            e.printStackTrace();
//            throw new RuntimeException("An unexpected error occurred while saving documents.");
//        }
//    }
//
//    private void saveFile(MultipartFile file, Long employeeId, String fileType) throws IOException {
//        if (file == null || file.isEmpty()) {
//            throw new IllegalArgumentException("File is empty or null");
//        }
//        // Ensure the upload directory exists
//        File uploadDir = new File(UPLOAD_DIR);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdirs(); // Create the directory if it does not exist
//        }
//        // Construct the file path
//        String filePath = UPLOAD_DIR + employeeId + "_" + fileType + "_" + file.getOriginalFilename();
//        File destinationFile = new File(filePath);
//        // Save the file
//        file.transferTo(destinationFile);
//    }
//
//    public Optional<EmployeeByDocument> getEmployeeDocumentById(Long employeeId) {
//        return documentRepository.findByEmployee_employeeId(employeeId);
//    }
//
//    public Resource loadDocumentAsResource(Long employeeId, String fileName) {
//        Optional<EmployeeByDocument> documentOptional = documentRepository.findByEmployee_employeeId(employeeId);
//        if (documentOptional.isPresent()) {
//            EmployeeByDocument document = documentOptional.get();
//            // Construct the file path for the requested file
//            File file = new File(UPLOAD_DIR + employeeId + "_" + fileName);
//            if (file.exists()) {
//                try {
//                    return new ByteArrayResource(java.nio.file.Files.readAllBytes(file.toPath()));
//                } catch (IOException e) {
//                    System.err.println("Failed to load file: " + e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//}
//    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";  // Adjust path as per your server
//
//    public void uploadDocument(MultipartFile file, String filename) throws IOException {
//        if (!file.isEmpty()) {
//            File uploadDir = new File(UPLOAD_DIR);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();  // Create directory if it doesn't exist
//            }
//            File dest = new File(UPLOAD_DIR + "/" + filename + "_" + file.getOriginalFilename());
//            file.transferTo(dest);  // Save file to the server
//        }
//    }
//}
 // Inject the directory path from the application.properties
    @Value("${file.upload-dir}")
    private String UPLOAD_DIR;

    public void uploadDocument(MultipartFile file, String filename) throws IOException {
        if (!file.isEmpty()) {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();  // Create the directory if it doesn't exist
            }
            File dest = new File(UPLOAD_DIR + "/" + filename + "_" + file.getOriginalFilename());
            file.transferTo(dest);  // Save file to the server
        }
    }
}