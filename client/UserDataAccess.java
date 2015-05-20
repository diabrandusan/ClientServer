package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import server.UserServiceInterface;
import database.User;

public class UserDataAccess {

	public List<User> getAllUser() throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/user?wsdl");
		QName qname = new QName("http://server/", "UserServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		UserServiceInterface serviceInterface = service
				.getPort(UserServiceInterface.class);
		User[] users = serviceInterface.getAllUser();
		return Arrays.asList(users);
	}

	public List<User> findUsernamePassword(String username, String password)
			throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/user?wsdl");
		QName qname = new QName("http://server/", "UserServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		UserServiceInterface serviceInterface = service
				.getPort(UserServiceInterface.class);
		User[] users = serviceInterface
				.findUsernamePassword(username, password);
		return Arrays.asList(users);
	}

	public User login(String username, String password) throws Exception {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/user?wsdl");
		QName qname = new QName("http://server/", "UserServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		UserServiceInterface serviceInterface = service
				.getPort(UserServiceInterface.class);
		User[] users = serviceInterface.login(username, password);
		if (users.length != 1) {
			throw new Exception("User not found!");
		}
		return users[0];
	}

	public void addUser(User user) throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/user?wsdl");
		QName qname = new QName("http://server/", "UserServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		UserServiceInterface serviceInterface = service
				.getPort(UserServiceInterface.class);
		serviceInterface.addUser(user);
	}

	public void updateUser(User user) throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/user?wsdl");
		QName qname = new QName("http://server/", "UserServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		UserServiceInterface serviceInterface = service
				.getPort(UserServiceInterface.class);
		serviceInterface.updateUser(user);
	}

	public void deleteUser(String username) throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/user?wsdl");
		QName qname = new QName("http://server/", "UserServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		UserServiceInterface serviceInterface = service
				.getPort(UserServiceInterface.class);
		serviceInterface.deleteUser(username);
	}
}
