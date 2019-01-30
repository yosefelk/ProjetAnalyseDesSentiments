package org.ensah.system.dao;

import java.util.List;

import org.ensah.system.beans.Notification;

public interface NotificationDao {
	
	public void saveNotification(Notification notification);

	public List<Notification> getAllNotifications(int userId);

}
