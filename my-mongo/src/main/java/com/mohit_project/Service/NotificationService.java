package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.NotificationDto;





public interface NotificationService {
	NotificationDto createNotification(NotificationDto notificationDto);
	NotificationDto updateNotification(NotificationDto notificationDto,Long notificationId);
	void deleteNotification(Long notificationId);
	NotificationDto getNotificationId(Long notificationId);
	List<NotificationDto> getAllNotification();

}
