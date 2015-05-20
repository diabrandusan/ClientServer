package server;

import javax.jws.WebService;

import database.Notification;
import database.notification.Doctor;

@WebService(endpointInterface = "server.NotificationServiceInterface")
public class NotificationServiceImpl implements NotificationServiceInterface {

	@Override
	public Notification[] getNotifications(String username) {
		Doctor doctor = new Doctor(username);
		return doctor.getNotifications();

	}

	@Override
	public void deleteNotify(int idNotification) {
		Doctor doctor = new Doctor(null);
		doctor.deleteNotify(idNotification);
	}

}
