package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import database.Notification;

@WebService
@SOAPBinding(style = Style.RPC)
public interface NotificationServiceInterface {

	@WebMethod
	public Notification[] getNotifications(String username);

	@WebMethod
	public void deleteNotify(int idNotification);
}
