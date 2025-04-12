package com.mohit_project.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Service.NotificationService;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.paylode.NotificationDto;


@RestController
@RequestMapping("/api/notification")
//@CrossOrigin("*")
public class NotificationContro {

	@Autowired
	private NotificationService notificationService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto){
		NotificationDto createNotification=this.notificationService.createNotification(notificationDto);
		return new ResponseEntity<NotificationDto>(createNotification,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{notificationId}")
	public ResponseEntity<NotificationDto> updateNotification(@RequestBody NotificationDto notificationDto,@PathVariable Long notificationId){
		NotificationDto updateNotification=this.notificationService.updateNotification(notificationDto, notificationId);
		return ResponseEntity.ok(updateNotification);
	}
	//delete
	@DeleteMapping("/{notificationId}")
	public ResponseEntity<ApiResponse> deleteNotification(@PathVariable Long notificationId){
		this.notificationService.deleteNotification(notificationId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getNotificationId
	@GetMapping("/{notificationId}")
	public ResponseEntity<NotificationDto> getNotificationId(@PathVariable Long notificationId){
		return ResponseEntity.ok(this.notificationService.getNotificationId(notificationId));
	}
	//getAllNotification
	@GetMapping("/")
	public ResponseEntity<List<NotificationDto>> getAllNotification(){
		return ResponseEntity.ok(this.notificationService.getAllNotification());
	}
}
