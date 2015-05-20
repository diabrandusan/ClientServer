package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import database.User;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserServiceInterface {

	@WebMethod
	public User[] getAllUser();

	@WebMethod
	public User[] findUsernamePassword(String username, String password);

	@WebMethod
	public User[] login(String username, String password);

	@WebMethod
	public void addUser(User user);

	@WebMethod
	public void deleteUser(String username);

	@WebMethod
	public void updateUser(User user);

}
