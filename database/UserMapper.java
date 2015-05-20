package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserMapper extends MapperBase<User> {

	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		try (Connection con = DatabaseConnection.getConnection();
				Statement statement = con.createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from user");
			while (resultSet.next()) {
				User user = map(resultSet);
				users.add(user);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving user from mapper:"
					+ e.getStackTrace());
		}
		return users;

	}

	public List<User> findUsernamePassword(String username, String password) {
		List<User> users = new ArrayList<User>();
		String query = "select * from user where username=? and password=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = map(resultSet);
				users.add(user);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving users from mapper:"
					+ e.getStackTrace());
		}

		return users;
	}

	public User getUser(String username) {
		User user = null;
		String query = "select * from user where username=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = map(resultSet);
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving user from mapper:"
					+ e.getStackTrace());
		}
		return user;
	}

	public User getType(String type) {
		User user = null;
		String query = "select * from user where type=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, type);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = map(resultSet);
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving user from mapper:"
					+ e.getStackTrace());
		}
		return user;
	}

	public void addUser(User user) {

		String query = "insert into user(username, password, type) values (?,?,?)";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getType());
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table user: ");
			e.printStackTrace();
		}

	}

	public void updateUser(User user) {

		String query = "update user set password=?, type=? where username=? ";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getType());
			statement.setString(3, user.getUsername());
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table user: ");
			e.printStackTrace();
		}

	}

	public void deleteUser(String username) {
		String query = "delete from user where username=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, username);
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error deleting from table user: ");
			e.printStackTrace();
		}

	}

	@Override
	protected User map(ResultSet resultSet) {
		User user = null;
		try {
			user = new User(resultSet.getString("username"),
					resultSet.getString("password"),
					resultSet.getString("type"));
		} catch (SQLException e) {
			System.err.println("Error retrieving user from mapper:"
					+ e.getStackTrace());
		}
		return user;
	}

}
