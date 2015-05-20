package client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import server.NotificationServiceInterface;
import database.Notification;

public class NotificationDataAccess {

	public Notification[] getNotifications(String username)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/notification?wsdl");
		QName qname = new QName("http://server/",
				"NotificationServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		NotificationServiceInterface serviceInterface = service
				.getPort(NotificationServiceInterface.class);
		return serviceInterface.getNotifications(username);

	}

	public void deleteNotify(int idNotification) throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/notification?wsdl");
		QName qname = new QName("http://server/",
				"NotificationServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		NotificationServiceInterface serviceInterface = service
				.getPort(NotificationServiceInterface.class);
		serviceInterface.deleteNotify(idNotification);
	}

}
