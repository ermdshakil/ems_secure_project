package com.mohit_project.Controller;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohit_project.Entity.Employee;
import com.mohit_project.Service.EmployeeService;
import com.mohit_project.Service.FileService;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.paylode.EmployeeDto;
import com.mohit_project.paylode.FileResponse;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/api/employee")

public class EmployeeContro {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Logger logger=LoggerFactory.getLogger(EmployeeContro.class);
	
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//create
	@PostMapping("/")
	public ResponseEntity<?> addImage(@RequestParam("userData") String image,@RequestParam("file") MultipartFile file  ) throws JsonProcessingException{
//		logger.info("file name {}",file.getOriginalFilename());
//		logger.info("image:{}",image);
		
		Employee employee=this.objectMapper.readValue(image, Employee.class);
		employee.setZName(file.getOriginalFilename());
		employee.setZmageName(file.getOriginalFilename());
		logger.info("image :{})",employee.getZmageName());
		EmployeeDto employeeDto=modelMapper.map(employee, EmployeeDto.class);
//		employeeDto.setZmageName(file.getOriginalFilename());
//		logger.info("image :{})",employeeDto.getZmageName());
		EmployeeDto employee2=this.employeeService.createEmployee(employeeDto);
		
		
		
		
		String fileName;
		try {
			fileName = this.fileService.uplodeImage(path, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null,"Image is successfully not uplodeed !!"), HttpStatus.OK);

		}
	
		
		
		
		return new ResponseEntity<FileResponse>(new FileResponse(fileName,"Image is successfully uplodeed !!"), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto createEmployeeDto=this.employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(createEmployeeDto,HttpStatus.CREATED);
	}
	//update
		@PutMapping("{employeeId}")
		public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long employeeId){
			EmployeeDto updateUser=this.employeeService.updateEmployee(employeeDto, employeeId);
			
			return  ResponseEntity.ok(updateUser);
		}
		
	
		//delete
		@DeleteMapping("/{employeeId}")
		public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long employeeId){
			this.employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
					HttpStatus.OK);
		}
		//getByID
		@GetMapping("/{employeeId}")
		public ResponseEntity<EmployeeDto> getEmployeeBId(@PathVariable Long employeeId){
			return ResponseEntity.ok(this.employeeService.getEmployeeId(employeeId));
		}
		
		//getAll
		@GetMapping("/")
		public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
			return ResponseEntity.ok(this.employeeService.getAllemployee());
		}
		//count
		@GetMapping("/count")
		 public ResponseEntity<Long> count() {
	        long count = employeeService.count();
	        return ResponseEntity.ok(count);
	    }
		
		@GetMapping("/total")
		 public ResponseEntity<Double> total(){
			 Double total=employeeService.total();
			 return ResponseEntity.ok(total);
		 }
		
		@GetMapping("/countm")
		public ResponseEntity<Long> countByMale(){
			return ResponseEntity.ok(this.employeeService.getMaleEmployeeCount());

		}
		@GetMapping("/countf")
		public ResponseEntity<Long> countByFemale(){
			return ResponseEntity.ok(this.employeeService.geFetmaleEmployeeCount());

		}
		@GetMapping("/countt")
		public ResponseEntity<Long> countByTrans(){
			return ResponseEntity.ok(this.employeeService.getTransEmployeeCount());

		}
		@GetMapping("/countc")
		public ResponseEntity<Long> countBycurrent(){
			return ResponseEntity.ok(this.employeeService.getCurrentEmployees());

		}

		@GetMapping("/countex")
		public ResponseEntity<Long> countByExEmployee(){
			return ResponseEntity.ok(this.employeeService.getExEmployeeEmployees());

		}

		@GetMapping("/countexit")
		public ResponseEntity<Long> countByExitedEmployee(){
			return ResponseEntity.ok(this.employeeService.getExitedEmployeeEmployees());

		}

		@GetMapping("/countn")
		public ResponseEntity<Long> countByNewjoining(){
			return ResponseEntity.ok(this.employeeService.getNewjoiningEmployees());

		}

		@GetMapping("/countti")
		public ResponseEntity<Long> countByTransferredIn(){
			return ResponseEntity.ok(this.employeeService.getTransferredInEmployees());

		}

		@GetMapping("/countto")
		public ResponseEntity<Long> countByTransferredOut(){
			return ResponseEntity.ok(this.employeeService.getTransferredOutEmployees());

		}
		
		//methode to serve file
		@GetMapping(value = "/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
		public void downlodeImage(@PathVariable ("imageName") String imageName,
				HttpServletResponse response) throws IOException {
			
			InputStream resource=this.fileService.getResource(path, imageName);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			StreamUtils.copy(resource, response.getOutputStream());}
		 @PostMapping("/login")
		    public Long loginEmployee(@RequestBody EmployeeLoginRequest request) {
		        return employeeService.validateEmployee(request.getEmail(), request.getPassword());
		    }

		    // DTO class for the login request
		    public static class EmployeeLoginRequest {
		        private String email;
		        private String password;

		        // Getters and Setters
		        public String getEmail() {
		            return email;
		        }

		        public void setEmail(String email) {
		            this.email = email;
		        }

		        public String getPassword() {
		            return password;
		        }

		        public void setPassword(String password) {
		            this.password = password;
		        }
		    }

		

}
