package com.mohit_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Service.UserService;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.paylode.UserDto;



@RestController
@RequestMapping("/api/user")

public class UserController {
	
	@Autowired
	private UserService userService; 
	
	//create
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUser=this.userService.creatUser(userDto);
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Long userId){
		UserDto updateUser=this.userService.updatUser(userDto, userId);
		return ResponseEntity.ok(updateUser);
		
	}
	//delete
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	
	//getById
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	//getAllUser
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	 @GetMapping("/count")
	    public ResponseEntity<Long> countUsers() {
	        long count = userService.countUsers();
	        return ResponseEntity.ok(count);
	    }
	 @PostMapping("/login")
	    public Long loginEmployee(@RequestBody EmployeeLoginRequest request) {
	        return userService.validateEmployee(request.getEmail(), request.getPassword());
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
