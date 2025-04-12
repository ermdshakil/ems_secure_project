package com.mohit_project.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
	
	private long notificationId;
	private String name;
	private String username;
	private String email;

}
