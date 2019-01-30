package org.ensah.system.service.impl;

import java.util.List;

import org.ensah.system.beans.Notification;
import org.ensah.system.dao.NotificationDao;
import org.ensah.system.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDao notificationDao;
	
	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	public void saveNotification(Notification Notification) {
		
		notificationDao.saveNotification(Notification);

	}

	@Override
	public List<Notification> getAllNotifications(int userId) {
		return notificationDao.getAllNotifications(userId);
	}

	

}
