package server;

import java.util.List;

import javax.jws.WebService;

import database.User;
import database.UserMapper;

@WebService(endpointInterface = "server.UserServiceInterface")
public class UserServiceImpl implements UserServiceInterface {

	@Override
	public User[] getAllUser() {
		UserMapper userMapper = new UserMapper();
		List<User> users = userMapper.getAllUser();
		return users.toArray(new User[users.size()]);

	}

	@Override
	public User[] findUsernamePassword(String username, String password) {
		UserMapper userMapper = new UserMapper();
		List<User> users = userMapper.findUsernamePassword(username, password);
		return users.toArray(new User[users.size()]);

	}

	@Override
	public void addUser(User user) {
		UserMapper userMapper = new UserMapper();
		userMapper.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		UserMapper userMapper = new UserMapper();
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(String username) {
		UserMapper userMapper = new UserMapper();
		userMapper.deleteUser(username);
	}

	@Override
	public User[] login(String username, String password) {
		UserMapper userMapper = new UserMapper();
		List<User> users = userMapper.findUsernamePassword(username, password);
		if (users.isEmpty()) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users.toArray(new User[users.size()]);

	}

}
