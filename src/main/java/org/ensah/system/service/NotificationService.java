package org.ensah.system.service;

import java.util.List;

import org.ensah.system.beans.Notification;
public interface NotificationService {
	
	public void saveNotification(Notification notification);

	public List<Notification> getAllNotifications(int userId);

}
